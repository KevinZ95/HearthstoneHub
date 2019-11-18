package com.example.hearthstonehub

import java.io.FileDescriptor

data class CardsInfo constructor(
    val cardID: Int,
    val cardName: String,
    val health: Int,
    val attack: Int,
    val manaCost: Int,
    val description: String,
    val image: String,
    val flavorText: String

)