package com.example.hearthstonehub

import java.io.FileDescriptor

data class CardsInfo constructor(
    val cardID: Number = 1,
    val cardName: String,
    val health: Number = 1,
    val attack: Number = 1,
    val manaCost: Number = 1,
    val description: String = "defult",
    val image: String = "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/e0e2f4755c6cc2e774ffa82afc378b46fbf5cc04c6fb4a34eea8a60811b66486.png",
    val flavorText: String = "defult"
)