package com.example.testeandroidhearthstone.data.model.response

import com.google.gson.annotations.SerializedName

data class CardImageResponse (
    @SerializedName("src") val image:String
)