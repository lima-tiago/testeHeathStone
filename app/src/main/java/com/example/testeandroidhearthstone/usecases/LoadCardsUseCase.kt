package com.example.testeandroidhearthstone.usecases

import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.response.Card_Entity
import io.reactivex.Observable

class LoadCardsUseCase(
    private val repository: ICardsRepository
) : ILoadCardsUseCase {

    fun execute(property:String,param:String): Observable<List<com.example.testeandroidhearthstone.domain.entities.Card_Entity>> {
        return repository.getCards(property, param)
    }
}