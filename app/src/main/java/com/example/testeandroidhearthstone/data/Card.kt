package com.example.testeandroidhearthstone.data

data class Card(
    val cardId: String,
    val cardSet: String,
    val cost: Int,
    val dbfId: String,
    val faction: String,
    val img: String,
    val imgGold: String,
    val locale: String,
    val name: String,
    val playerClass: String,
    val text: String,
    val type: String
)