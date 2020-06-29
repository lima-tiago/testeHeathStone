package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

interface ICardsRepository {
    fun getInfo(): Observable<InfoResponse>
    fun getCards(property: String, param: String): Observable<List<CardResponse>>
}