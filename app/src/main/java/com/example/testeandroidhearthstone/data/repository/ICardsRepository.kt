package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.data.model.Card
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

interface ICardsRepository {
    fun getInfo(): Observable<InfoResponse>
    fun getCards(property: String, param: String): Observable<List<CardResponse>>


    fun insert(card: Card)
    fun update(card: Card)
    fun delete(card: Card)
    fun deleteAllCards()
    fun getAllCards(): Observable<List<Card>>
}