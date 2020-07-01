package com.example.testeandroidhearthstone.network

import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/info")
    fun getInfo(): Observable<InfoResponse>

    @GET("/cards/sets/{param}")
    fun getCardsBySet(@Path("param") param: String): Observable<List<Card_Entity>>

    @GET("/cards/classes/{param}")
    fun getCardsByClass(@Path("param") param: String): Observable<List<Card_Entity>>

    @GET("/cards/races/{param}")
    fun getCardsByRaces(@Path("param") param: String): Observable<List<Card_Entity>>

    @GET("/cards/qualities/{param}")
    fun getCardsByQualities(@Path("param") param: String): Observable<List<Card_Entity>>

    @GET("/cards/types/{param}")
    fun getCardsByTypes(@Path("param") param: String): Observable<List<Card_Entity>>

    @GET("/cards/factions/{param}")
    fun getCardsByFactions(@Path("param") param: String): Observable<List<Card_Entity>>

}

//https://api.themoviedb.org/3/movie/popular?api_key=1acd1c4252829be77f647c7ca27d6555&language=pt-BR&page=1
