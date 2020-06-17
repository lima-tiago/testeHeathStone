package com.example.testeandroidhearthstone.network.response

import com.google.gson.annotations.SerializedName

data class CardImageResponse (
    @SerializedName("src") val image:String
)