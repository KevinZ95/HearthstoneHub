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
/*
    fun retrieveOAuth(apiKey: String, apiSecret: String ): String{
        val request = Request.Builder()
            .url("https://api.twitter.com/oauth2/token")
            .header("Authorization", "Basic $base64Combined")
            .post(requestBody)
            .build()

    }
*/
    val accessToken = "USuVhFISaG0vGpniXHZofpy5E13q35GnUK"




    // Searching deck

    fun retrieveDeckInfo(deckCode: String): List<CardsInfo> {

        val locale = "en_US"

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/deck/$deckCode&?locale=$locale&access_token=$accessToken")
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
                //val description = curr.getString("text")
                val flavorText = curr.getString("flavorText")
                val image = curr.getString("image")

                deck.add(
                    CardsInfo(
                        cardID = id,
                        cardName = name,
                        health = health,
                        attack = attack,
                        manaCost = manaCost,
                        //description = description,
                        image = image,
                        flavorText = flavorText
                    )
                )
            }

            }


        return deck
    }

        // searching weapon
        fun retrieveWeaponInfo(): List<CardsInfo> {


            val locale = "en_US"


            val request = Request.Builder()
                .url("https://us.api.blizzard.com/hearthstone/cards?locale=$locale&type=weapon&sort=name&order=asc&access_token=$accessToken")
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
                    val health = curr.getInt("durability")
                    val attack = curr.getInt("attack")
                    val manaCost = curr.getInt("manaCost")
                    //val description = curr.getString("text")
                    val flavorText = curr.getString("flavorText")
                    val image = curr.getString("image")

                    weaponList.add(
                        CardsInfo(
                            cardID = id,
                            cardName = name,
                            health = health,
                            attack = attack,
                            manaCost = manaCost,
                            //description = description,
                            image = image,
                            flavorText = flavorText
                        )
                    )
                }


            }


            return weaponList
        }

    // searching Hero cards
    fun retrieveHeroInfo(): List<CardsInfo> {


        val locale = "en_US"

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$locale&type=hero&sort=name&order=asc&access_token=$accessToken")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()
        val heroList = mutableListOf<CardsInfo>()

        if (response.isSuccessful && !responseString.isNullOrEmpty()) {
            val json = JSONObject(responseString)
            val cards = json.getJSONArray("cards")

            for (i in 0 until cards.length()) {
                val curr = cards.getJSONObject(i)
                val id = curr.getInt("id")
                val name = curr.getString("name")
                val health = curr.getInt("health")
                //val armor = curr.getInt("armor")
                val manaCost = curr.getInt("manaCost")
                val flavorText = curr.getString("flavorText")
                val image = curr.getString("image")

                if (image != "") { // only present the hero-cards which have uniqe
                    heroList.add(
                        CardsInfo(
                            cardID = id,
                            cardName = name,
                            health = health,
                            attack = 0,
                            manaCost = manaCost,
                            image = image,
                            flavorText = flavorText
                        )
                    )
                }

            }


        }


        return heroList
    }

    // searching minions
    fun retrieveMinionInfo(): List<CardsInfo> {


        val locale = "en_US"

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$locale&type=minion&sort=name&order=asc&access_token=$accessToken")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()
        val minionList = mutableListOf<CardsInfo>()

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
                //val description = curr.getString("text")
                val flavorText = curr.getString("flavorText")
                val image = curr.getString("image")

                minionList.add(
                    CardsInfo(
                        cardID = id,
                        cardName = name,
                        health = health,
                        attack = attack,
                        manaCost = manaCost,
                        //description = description,
                        image = image,
                        flavorText = flavorText
                    )
                )
            }


        }

        return minionList
    }


    // searching spell
    fun retrieveSpellInfo(classType: String): List<Spell_Info> {


        val locale = "en_US"

        val classType = classType

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$locale&class=$classType&type=spell&sort=manaCost&order=asc&access_token=$accessToken")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()
        val spellList = mutableListOf<Spell_Info>()

        if (response.isSuccessful && !responseString.isNullOrEmpty()) {
            val json = JSONObject(responseString)
            val cards = json.getJSONArray("cards")

            for (i in 0 until cards.length()) {
                val curr = cards.getJSONObject(i)
                val id = curr.getInt("id")
                val name = curr.getString("name")
                val manaCost = curr.getInt("manaCost")
                //val description = curr.getString("text")
                val flavorText = curr.getString("flavorText")
                val image = curr.getString("image")

                spellList.add(
                    Spell_Info(
                        cardID = id,
                        cardName = name,
                        manaCost = manaCost,
                        //description = description,
                        image = image,
                        flavorText = flavorText
                    )
                )
            }


        }
        return spellList
    }
}