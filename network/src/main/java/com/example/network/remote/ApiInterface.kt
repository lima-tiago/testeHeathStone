package com.example.network.remote

import com.example.network.response.CardResponse
import com.example.network.response.HomeInfoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/info")
    fun getInfo(): Observable<HomeInfoResponse>

    @GET("/cards/sets/{param}")
    fun getCardsBySet(@Path( "param") param: String): Observable<List<CardResponse>>

    @GET("/cards/classes/{param}")
    fun  getCardsByClass(@Path("param") param: String): Observable<List<CardResponse>>

    @GET("/cards/races/{param}")
    fun getCardsByRaces(@Path("param") param: String): Observable<List<CardResponse>>

    @GET("/cards/qualities/{param}")
    fun  getCardsByQualities(@Path("param") param: String): Observable<List<CardResponse>>

    @GET("/cards/types/{param}")
    fun getCardsByTypes(@Path("param") param: String): Observable<List<CardResponse>>

    @GET("/cards/factions/{param}")
    fun  getCardsByFactions(@Path("param") param: String): Observable<List<CardResponse>>

}

//@GET("/cards/{property}/{param}")
//fun getCards(@Path( "param") param: String,
//             @Path("property")property: String): Observable<List<CardResponse>>

//https://api.themoviedb.org/3/movie/popular?api_key=1acd1c4252829be77f647c7ca27d6555&language=pt-BR&page=1
