package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.OrientationHelper.*
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.doAsync
import java.lang.Exception
import androidx.recyclerview.widget.OrientationHelper.HORIZONTAL as HORIZONTAL

class cards_spell_list : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_spell_list)

        val mage = findViewById<ImageButton>(R.id.spell_mage)
        val paladin = findViewById<ImageButton>(R.id.spell_paladin)
        val druid = findViewById<ImageButton>(R.id.spell_druid)
        val hunter = findViewById<ImageButton>(R.id.spell_hunter)
        val priest = findViewById<ImageButton>(R.id.spell_priest)
        val rogue = findViewById<ImageButton>(R.id.spell_rogue)
        val shaman = findViewById<ImageButton>(R.id.spell_shaman)
        val warlock = findViewById<ImageButton>(R.id.spell_warlock)
        val warrior = findViewById<ImageButton>(R.id.spell_warrior)

        var myLanguage = "en_US" // default



        // mage spells
        mage.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"

                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("mage", myLanguage, recyclerView)

        }

        // druid spell
        druid.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("druid", myLanguage, recyclerView)

        }


        // hunter spell
        hunter.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("hunter",myLanguage,recyclerView)

        }

        // paladin spell
        paladin.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("paladin",myLanguage,recyclerView)
        }
        // priest spell
        priest.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("priest",myLanguage,recyclerView)
        }
        // rogue spell
        rogue.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("rogue",myLanguage,recyclerView)


        }
        // shaman spell
        shaman.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("shaman",myLanguage,recyclerView)
        }
        // warlock spell
        warlock.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("warlock",myLanguage,recyclerView)
        }
        // warrior spell
        warrior.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            val language = findViewById<CompoundButton>(R.id.language_2)
            language.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    myLanguage = "zh_CN"
                } else {
                    myLanguage = "en_US"
                }
            })

            searchSpell("warrior",myLanguage,recyclerView)

        }


    }

    fun searchSpell(classType: String, myLanguage: String, myView: RecyclerView) {

        doAsync {

            val cardsManager = CardManager()
            val myID = getString(R.string.client_id)
            val mySecret = getString(R.string.client_secret)
            val accessToken = cardsManager.battleNetOAuth(myID, mySecret)

            try {

                val resultList = cardsManager.retrieveSpellInfo(classType, myLanguage, accessToken)

                runOnUiThread{
                    myView.adapter = SpellAdapter(resultList)
                }
            } catch(e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@cards_spell_list,
                        "Error retriving info",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }



    }

}
