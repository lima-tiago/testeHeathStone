package com.example.testeandroidhearthstone.usecases

import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

class LoadCardsUseCase(
    private val repository: ICardsRepository
) : ILoadCardsUseCase {

    fun execute(property:String,param:String): Observable<List<CardResponse>>{
        return repository.getCards(property, param)
    }
}