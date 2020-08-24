package com.example.network.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var myInterface: ApiInterface? = null
    private val interceptor =
        SupportInterceptor()

    private val okHttp = OkHttpClient.Builder().addInterceptor(interceptor)
    val gson = GsonBuilder().setLenient().create()

    fun getClient(): ApiInterface {
        myInterface?.let {
            return it
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttp.build())
            .build()

        myInterface = retrofit.create(
            ApiInterface::class.java)

        return myInterface!!
    }
}