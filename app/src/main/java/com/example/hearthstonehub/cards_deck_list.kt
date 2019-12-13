package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper.*
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import java.lang.Exception

class cards_deck_list : AppCompatActivity() {

    private lateinit var recyclerView_spell: RecyclerView
    private lateinit var recyclerView_minion: RecyclerView
    private var myLanguage = "en_US" // default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_deck_list)


        val deckCodeInput: String = intent.getStringExtra("deckCodeInput")


        recyclerView_spell = findViewById(R.id.deck_spell_list)
        recyclerView_minion = findViewById(R.id.deck_minion_list)

        recyclerView_spell.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        recyclerView_minion.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)


        val language = findViewById<CompoundButton>(R.id.language_3)

        language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                myLanguage = "zh_CN"
                searchDeck(deckCodeInput, recyclerView_spell,recyclerView_minion)
            } else {
                this.recreate()
            }
        })

        searchDeck(deckCodeInput, recyclerView_spell,recyclerView_minion)















    }

    fun searchDeck(deckCodeInput: String, myView_spell: RecyclerView, myView_minion: RecyclerView) {
        doAsync {

            val deckManager = DeckManager()
            val myID = getString(R.string.client_id)
            val mySecret = getString(R.string.client_secret)
            val accessToken = deckManager.battleNetOAuth(myID, mySecret)
            try {

                val spellList = deckManager.retrieveDeckSpell(deckCodeInput, myLanguage, accessToken)
                val minionlList = deckManager.retrieveDeckMinion(deckCodeInput, myLanguage, accessToken)

                runOnUiThread{
                    myView_spell.adapter = SpellAdapter(spellList)
                    myView_minion.adapter = CardAdapter(minionlList)
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
