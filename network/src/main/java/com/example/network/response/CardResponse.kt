package com.example.network.response

import com.google.gson.annotations.SerializedName

data class CardResponse(
    @SerializedName("cardId") val cardId: String,
    @SerializedName("img") var img: String,
    @SerializedName("locale") val locale: String,
    @SerializedName("type") val type: String
)