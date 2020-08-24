package com.example.data.repositories

import com.example.network.response.CardResponse
import io.reactivex.Observable

interface ICardsRepository {
    fun getCards(property: String, param: String): Observable<List<CardResponse>>
}