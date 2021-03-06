package com.example.hearthstonehub


import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class DeckManager {


    private val okHttpClient: OkHttpClient

    init {

        val builder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logging)

        okHttpClient = builder.build()


    }

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


    // Searching deck minion

    fun retrieveDeckMinion(deckCode: String, language: String, accessToken: String): List<CardsInfo> {


         val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/deck/$deckCode&?locale=$language&access_token=$accessToken")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()

        val deckMinion = mutableListOf<CardsInfo>()

        if (response.isSuccessful && !responseString.isNullOrEmpty()) {
            val json = JSONObject(responseString)
            val statuses = json.getJSONArray("cards")

            for (i in 0 until statuses.length()) {

                val curr = statuses.getJSONObject(i)
                val cardType = curr.getInt("cardTypeId")

                if (cardType != 5) { // then this is NOT a spell card

                    if (cardType == 7) { // then this is a weapon card
                        val id = curr.getInt("id")
                        val name = curr.getString("name")
                        val health = curr.getInt("durability") // weapon has durability instead of health
                        val attack = curr.getInt("attack")
                        val manaCost = curr.getInt("manaCost")
                        val flavorText = curr.getString("flavorText")
                        val image = curr.getString("image")
                        deckMinion.add(
                            CardsInfo(
                                cardID = id,
                                cardName = name,
                                health = health,
                                attack = attack,
                                manaCost = manaCost,
                                image = image,
                                flavorText = flavorText
                            )
                        )

                    } else if (cardType == 3) { // then this is a hero card
                        val id = curr.getInt("id")
                        val name = curr.getString("name")
                        val health = curr.getInt("health")
                        // val attack = curr.getInt("attack")
                        val manaCost = curr.getInt("manaCost") // hero cards have no attack
                        val flavorText = curr.getString("flavorText")
                        val image = curr.getString("image")
                        deckMinion.add(
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

                    } else {
                        val id = curr.getInt("id")
                        val name = curr.getString("name")
                        val health = curr.getInt("health")
                        val attack = curr.getInt("attack")
                        val manaCost = curr.getInt("manaCost")
                        val flavorText = curr.getString("flavorText")
                        val image = curr.getString("image")
                        deckMinion.add(
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

            }

        }


        return deckMinion
    }

    // searching spell cards
    fun retrieveDeckSpell(deckCode: String, language: String, accessToken: String): List<Spell_Info> {

         val request = Request.Builder()
            .url("https://us.api.blizzard.com/hearthstone/deck/$deckCode&?locale=$language&access_token=$accessToken")
            //.header("Authorization","Bearer USsfKdzCkWSfUmFwk6mN6s5U9pbI0lCdOA")
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseString = response.body?.string()

        val deckSpell = mutableListOf<Spell_Info>()

        if (response.isSuccessful && !responseString.isNullOrEmpty()) {
            val json = JSONObject(responseString)
            val statuses = json.getJSONArray("cards")

            for (i in 0 until statuses.length()) {

                val curr = statuses.getJSONObject(i)
                val cardType = curr.getInt("cardTypeId")

                if (cardType == 5) { // then this is a spell card
                    val id = curr.getInt("id")
                    val name = curr.getString("name")
                    val manaCost = curr.getInt("manaCost")
                    //val description = curr.getString("text")
                    val flavorText = curr.getString("flavorText")
                    val image = curr.getString("image")
                    deckSpell.add(
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

        }


        return deckSpell
    }





}