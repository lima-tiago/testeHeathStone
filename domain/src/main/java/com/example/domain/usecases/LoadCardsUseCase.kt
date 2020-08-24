package com.example.domain.usecases

import com.example.domain.model.request.CardsRequest
import com.example.network.response.CardResponse
import com.example.data.repositories.ICardsRepository
import io.reactivex.Observable

class LoadCardsUseCase(
    private val repository: ICardsRepository
) : ILoadCardsUseCase {

    override fun execute(params: CardsRequest): Observable<List<CardResponse>> {
        return repository.getCards(params.property,params.param)
    }
}