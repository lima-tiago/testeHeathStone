package com.example.testeandroidhearthstone.domain.repositories

import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import io.reactivex.Observable

interface ICardsRepository {

    fun getCards(property: String, param: String): Observable<List<CardsResponse>>
}