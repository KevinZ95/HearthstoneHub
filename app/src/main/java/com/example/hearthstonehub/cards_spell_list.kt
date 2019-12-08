package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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




        // mage spells
        mage.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("mage")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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

        // druid spell
        druid.setOnClickListener {

            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("druid")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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


        // hunter spell
        hunter.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("hunter")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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

        // paladin spell
        paladin.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("paladin")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
        // priest spell
        priest.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("priest")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
        // rogue spell
        rogue.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("rogue")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
        // shaman spell
        shaman.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("shaman")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
        // warlock spell
        warlock.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("warlock")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
        // warrior spell
        warrior.setOnClickListener {
            recyclerView = findViewById(R.id.spell_recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

            doAsync {

                val cardsManager = CardManager()

                try {

                    val resultList = cardsManager.retrieveSpellInfo("warrior")

                    runOnUiThread{
                        recyclerView.adapter = SpellAdapter(resultList)
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
}
