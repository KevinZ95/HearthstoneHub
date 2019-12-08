package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import java.lang.Exception

class Single_card_info : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_card_info)


        val searchingType: Int = intent.getIntExtra("searchingType", 0)
        //val deckCodeInput: String = intent.getStringExtra("deckCodeInput")



        recyclerView = findViewById(R.id.deck_spell_list)

        recyclerView.layoutManager = LinearLayoutManager(this)

        /*
        doAsync {
            val cardManager = CardManager()
            val cards = cardManager.retrieveWeaponInfo()

            runOnUiThread{
                recyclerView.adapter = CardAdapter(cards)
            }

        }
*/




        if (searchingType == 1) { // searching weapon
            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveWeaponInfo()

                    runOnUiThread{
                        recyclerView.adapter = CardAdapter(resultList)
                    }
                } catch(e: Exception) {
                    runOnUiThread {
                        Toast.makeText(this@Single_card_info,
                            "Error retriving info",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        } else if (searchingType == 2) { // searching hearo cards
            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveHeroInfo()

                    runOnUiThread{
                        recyclerView.adapter = CardAdapter(resultList)
                    }
                } catch(e: Exception) {
                    runOnUiThread {
                        Toast.makeText(this@Single_card_info,
                            "Error retriving info",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        } else {
            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveMinionInfo()

                    runOnUiThread{
                        recyclerView.adapter = CardAdapter(resultList)
                    }
                } catch(e: Exception) {
                    runOnUiThread {
                        Toast.makeText(this@Single_card_info,
                            "Error retriving info",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }









    }

    fun fakeCards(): List<CardsInfo> {
        return listOf(
            CardsInfo(
                cardID = 1111,
                cardName = "1111",
                health = 1,
                attack = 1,
                manaCost = 1,
                //description = " 1 test",
                image = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b9b255afedfa7e8e08e96feda019b9c942d9220019193b6d76eb62d5c4e7747d.png",
                flavorText = "1 test"
            ),
            CardsInfo(
                cardID = 22222,
                cardName = "2222",
                health = 2,
                attack = 2,
                manaCost = 2,
                //description = " 2 test",
                image = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b9b255afedfa7e8e08e96feda019b9c942d9220019193b6d76eb62d5c4e7747d.png",
                flavorText = "2 test"
            ),
            CardsInfo(
                cardID = 3333,
                cardName = "3333",
                health = 3,
                attack = 3,
                manaCost = 3,
                //description = " 3 test",
                image = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b9b255afedfa7e8e08e96feda019b9c942d9220019193b6d76eb62d5c4e7747d.png",
                flavorText = "3 test"
            ),
            CardsInfo(
                cardID = 4444,
                cardName = "4444",
                health = 4,
                attack = 4,
                manaCost = 4,
                //description = " 4 test",
                image = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b9b255afedfa7e8e08e96feda019b9c942d9220019193b6d76eb62d5c4e7747d.png",
                flavorText = "4 test"
            )


        )
    }


}
