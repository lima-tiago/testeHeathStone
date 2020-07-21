package com.example.testeandroidhearthstone.domain.usecases

import com.example.testeandroidhearthstone.commons.UseCase
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse

interface ILoadHomeInfoUseCase : UseCase.FromObservable.WithoutParameter<HomeInfoResponse>
