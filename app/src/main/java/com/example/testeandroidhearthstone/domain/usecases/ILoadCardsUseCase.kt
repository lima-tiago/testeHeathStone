package com.example.testeandroidhearthstone.domain.usecases

import com.example.testeandroidhearthstone.commons.UseCase
import com.example.testeandroidhearthstone.data.model.request.CardsRequest
import com.example.testeandroidhearthstone.data.model.response.Card
import com.example.testeandroidhearthstone.domain.entities.Card_Entity

interface ILoadCardsUseCase : UseCase.FromObservable.WithParameter<CardsRequest, List<Card_Entity>>
