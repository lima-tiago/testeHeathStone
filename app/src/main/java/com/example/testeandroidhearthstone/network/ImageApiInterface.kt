package com.example.testeandroidhearthstone.network

import com.example.testeandroidhearthstone.network.response.CardImageResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImageApiInterface {

    @GET("{locale}/256x/{cardId}.png")
    fun getCardImage(locale: String, cardId: String) : Call<CardImageResponse>
}