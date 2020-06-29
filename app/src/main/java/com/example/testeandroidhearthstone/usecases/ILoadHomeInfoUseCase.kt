package com.example.testeandroidhearthstone.usecases

import com.example.testeandroidhearthstone.commons.UseCase
import com.example.testeandroidhearthstone.network.response.InfoResponse

interface ILoadHomeInfoUseCase : UseCase.FromObservable.WithParameter<Boolean,InfoResponse>
