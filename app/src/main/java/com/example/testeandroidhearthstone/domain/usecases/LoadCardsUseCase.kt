package com.example.testeandroidhearthstone.domain.usecases

import com.example.testeandroidhearthstone.data.model.request.CardsRequest
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.domain.repositories.ICardsRepository
import io.reactivex.Observable

class LoadCardsUseCase(
    private val repository: ICardsRepository
) : ILoadCardsUseCase {

    override fun execute(params: CardsRequest): Observable<List<Card_Entity>> {
        return repository.getCards(params.property,params.param)
    }
}