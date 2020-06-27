package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.core.Observable

interface ICardsRepository {

//    fun getCards(property: String, param: String)

    fun getCardsBySet(param:String): Observable<List<CardResponse>>
    fun getCardsByClass(param:String): Observable<List<CardResponse>>
    fun getCardsByRaces(param:String): Observable<List<CardResponse>>
    fun getCardsByQualities(param:String): Observable<List<CardResponse>>
    fun getCardsByTypes(param:String): Observable<List<CardResponse>>
    fun getCardsByFactions(param:String): Observable<List<CardResponse>>

}