package com.example.domain.usecases

import com.example.commons.UseCase
import com.example.domain.model.request.CardsRequest
import com.example.network.response.CardResponse

interface ILoadCardsUseCase : UseCase.FromObservable.WithParameter<CardsRequest, List<CardResponse>>
