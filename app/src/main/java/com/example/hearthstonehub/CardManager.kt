package com.example.hearthstonehub

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Request
import org.json.JSONObject


class CardManager {


    private val okHttpClient: OkHttpClient

    init {

        val builder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logging)

        okHttpClient = builder.build()



    }

    // Searching deck
/*
    fun retrieveDeckInfo(deckCode: String): List<CardsInfo> {

        val locale = "en_US"

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/deck/$deckCode&?locale=$locale&access_token=USMFaWz2gTY0AiWaiMaEKI3hmVso9CE3bm")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()

        val deck = mutableListOf<CardsInfo>()

        if (response.isSuccessful && !responseString.isNullOrEmpty()) {
            val json = JSONObject(responseString)
            val statuses = json.getJSONArray("cards")

            for (i in 0 until statuses.length()) {
                val curr = statuses.getJSONObject(i)
                val id = curr.getInt("id")
                val name = curr.getString("name")
                val health = curr.getInt("health")
                val attack = curr.getInt("attack")
                val manaCost = curr.getInt("manaCost")
                val description = curr.getString("text")
                val flavorText = curr.getString("flavorText")
                val image = curr.getString("image")

                deck.add(
                    CardsInfo(
                        cardID = id,
                        cardName = name,
                        health = health,
                        attack = attack,
                        manaCost = manaCost,
                        description = description,
                        image = image,
                        flavorText = flavorText
                    )
                )
            }

            }


        return deck
    }

*/
        fun retrieveWeaponInfo(): List<CardsInfo> {


            val locale = "en_US"
            val request = Request.Builder()
                .url("https://us.api.blizzard.com/hearthstone/cards?locale=$locale&type=weapon&sort=name&order=desc&access_token=USMFaWz2gTY0AiWaiMaEKI3hmVso9CE3bm")
                //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
                .build()

            val response = okHttpClient.newCall(request).execute()
            val responseString = response.body?.string()
            val weaponList = mutableListOf<CardsInfo>()

            if (response.isSuccessful && !responseString.isNullOrEmpty()) {
                val json = JSONObject(responseString)
                val cards = json.getJSONArray("cards")

                for (i in 0 until cards.length()) {
                    val curr = cards.getJSONObject(i)
                    val id = curr.getInt("id")
                    val name = curr.getString("name")
                    val health = curr.getInt("health")
                    val attack = curr.getInt("attack")
                    val manaCost = curr.getInt("manaCost")
                    val description = curr.getString("text")
                    val flavorText = curr.getString("flavorText")
                    val image = curr.getString("image")

                    weaponList.add(
                        CardsInfo(
                            //cardID = id,
                            cardName = name
                            //health = health,
                            //attack = attack,
                            //manaCost = manaCost
                            //description = description,
                            //image = image,
                            //flavorText = flavorText
                        )
                    )
                }


            }


            return weaponList
        }


    }