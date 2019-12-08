package com.example.hearthstonehub

import java.io.FileDescriptor

data class CardsInfo constructor(
    val cardID: Number,
    val cardName: String,
    val health: Number,
    val attack: Number,
    val manaCost: Number,
    // val description: String,
    val image: String,
    val flavorText: String
)