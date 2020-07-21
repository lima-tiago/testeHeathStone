package com.example.testeandroidhearthstone.data.remote

import com.example.testeandroidhearthstone.data.model.response.CardImageResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImageApiInterface {

    @GET("{locale}/256x/{cardId}.png")
    fun getCardImage(locale: String, cardId: String) : Call<CardImageResponse>
}