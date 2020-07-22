package com.example.testeandroidhearthstone.domain.repositories

import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import io.reactivex.Observable

interface ICardsRepository {

    fun getCards(property: String, param: String): Observable<List<CardsResponse>>

    fun insert(card: Card_Entity)
//    fun update(card: com.example.testeandroidhearthstone.domain.entities.Card)
//    fun delete(card: com.example.testeandroidhearthstone.domain.entities.Card)
    fun deleteAllCards()
//    fun getAllCards(): Observable<List<Card>>
    fun getCardsWithId(): Observable<List<Card_Entity>>
}