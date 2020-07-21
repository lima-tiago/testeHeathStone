package com.example.testeandroidhearthstone.data.model.response

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("cardId") val cardId: String,
    @SerializedName("img") var img: String,
    @SerializedName("imgGold") val imgGold: String,
    @SerializedName("locale") val locale: String,
    @SerializedName("type") val type: String
)