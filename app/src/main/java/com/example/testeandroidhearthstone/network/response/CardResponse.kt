package com.example.testeandroidhearthstone.network.response

import com.google.gson.annotations.SerializedName

data class CardResponse(
    @SerializedName("cardId") val cardId: String,
//    @SerializedName("cardSet") val cardSet: String,
//    @SerializedName("dbfId") val dbfId: String,
//    @SerializedName("health") val health: Int,
    @SerializedName("img") var img: String,
    @SerializedName("imgGold") val imgGold: String,
    @SerializedName("locale") val locale: String,
//    @SerializedName("name") val name: String,
//    @SerializedName("playerClass") val playerClass: String,
//    @SerializedName("text") val text: String,
    @SerializedName("type") val type: String
)