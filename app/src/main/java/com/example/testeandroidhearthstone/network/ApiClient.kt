package com.example.testeandroidhearthstone.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var myInterface: ApiInterface? = null
    private val interceptor = SupportInterceptor()

    private val okHttp = OkHttpClient.Builder().addInterceptor(interceptor)

    fun getClient(): ApiInterface {
        myInterface?.let {
            return it
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()

        myInterface = retrofit.create(ApiInterface::class.java)

        return myInterface!!
    }
}