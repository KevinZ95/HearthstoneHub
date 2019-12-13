package com.example.hearthstonehub

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Request
import org.json.JSONObject
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

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
fun battleNetOAuth(client_id: String, client_secret: String): String {
    val requestBody =
        "grant_type=client_credentials&client_id=$client_id&client_secret=$client_secret"
            .toRequestBody(
                contentType = "application/x-www-form-urlencoded".toMediaType()
            )

    val request = Request.Builder()
        .url("https://us.battle.net/oauth/token")
        .post(requestBody)
        .build()

    val response = okHttpClient.newCall(request).execute()
    val responseString = response.body?.string()
    val json = JSONObject(responseString)
    val accessToken = json.getString("access_token")
    return accessToken
}


        // searching weapon
        fun retrieveWeaponInfo(language: String, accessToken: String): List<CardsInfo> {



            val request = Request.Builder()
                .url("https://us.api.blizzard.com/hearthstone/cards?locale=$language&type=weapon&sort=name&order=asc&access_token=$accessToken")
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
    fun retrieveHeroInfo(language: String, accessToken: String): List<CardsInfo> {

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$language&type=hero&sort=name&order=asc&access_token=$accessToken")
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
    fun retrieveMinionInfo(language: String, accessToken: String): List<CardsInfo> {



        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$language&type=minion&sort=name&order=asc&access_token=$accessToken")
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
    fun retrieveSpellInfo(classType: String, language: String, accessToken: String): List<Spell_Info> {


        val classType = classType

        val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/cards?locale=$language&class=$classType&type=spell&sort=manaCost&order=asc&access_token=$accessToken")
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