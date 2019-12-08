package com.example.hearthstonehub

data class Spell_Info constructor(
    val cardID: Number,
    val cardName: String,
    val manaCost: Number,
    // val description: String,
    val image: String,
    val flavorText: String
)