package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper.*
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import java.lang.Exception

class cards_deck_list : AppCompatActivity() {

    private lateinit var recyclerView_spell: RecyclerView
    private lateinit var recyclerView_minion: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_deck_list)


        val deckCodeInput: String = intent.getStringExtra("deckCodeInput")


        recyclerView_spell = findViewById(R.id.deck_spell_list)
        recyclerView_minion = findViewById(R.id.deck_minion_list)

        recyclerView_spell.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        recyclerView_minion.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

        /*
        doAsync {
            val cardManager = CardManager()
            val cards = cardManager.retrieveWeaponInfo()

            runOnUiThread{
                recyclerView.adapter = CardAdapter(cards)
            }

        }

*/



        doAsync {

            val deckManager = DeckManager()

            try {

                val spellList = deckManager.retrieveDeckSpell(deckCodeInput)
                val minionlList = deckManager.retrieveDeckMinion(deckCodeInput)

                runOnUiThread{
                    recyclerView_spell.adapter = SpellAdapter(spellList)
                    recyclerView_minion.adapter = CardAdapter(minionlList)
                }
            } catch(e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@cards_deck_list,
                        "Error retriving info",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }










        }
}
