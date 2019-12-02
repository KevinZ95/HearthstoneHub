package com.example.hearthstonehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_cards_main_types.*

class cards_main_types : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_main_types)


        val goSpell = findViewById<Button>(R.id.type_spell)
        val goWeapon  = findViewById<Button>(R.id.type_weapon)
        val goMinion = findViewById<Button>(R.id.type_minion)
        val goHero = findViewById<Button>(R.id.types_hero)

        var searchingType = 0;
        // weapon: 1
        // hero: 2
        // deck = 3

        var deckCode = findViewById(R.id.deck_code_input) as EditText

        val goDeck = findViewById<Button>(R.id.search_deck)



        // spell and minion have sub-list
        goSpell.setOnClickListener {
            val intent = Intent(this@cards_main_types, cards_spell_list::class.java)
            //intent.putExtra("address", title)
            startActivity(intent)
        }

        goMinion.setOnClickListener {
            val intent = Intent(this@cards_main_types, cards_minion_list::class.java)
            startActivity(intent)
        }

        // weapon and hero go directly to card list
        goWeapon.setOnClickListener {
            // setting searchingType as weapon
            searchingType = 1
            val intent = Intent(this@cards_main_types, Single_card_info::class.java)
            intent.putExtra("searchingType", searchingType)
            startActivity(intent)
        }

        goHero.setOnClickListener {
            // setting searchingType as hero
            searchingType = 2
            val intent = Intent(this@cards_main_types, Single_card_info::class.java)
            intent.putExtra("searchingType", searchingType)
            startActivity(intent)
        }

        goDeck.setOnClickListener {
            // setting searchingType as deck
            searchingType = 3
            // testing
            val testingCode = "AAECAQcG+wyd8AKS+AKggAOblAPanQMMS6IE/web8wLR9QKD+wKe+wKz/AL1gAOXlAOalAOSnwMA"
            val intent = Intent(this@cards_main_types, Single_card_info::class.java)
            intent.putExtra("searchingType", searchingType)
            intent.putExtra("deckCodeInput", /*deckCode.toString()*/ testingCode)
            startActivity(intent)
        }


    }
}
