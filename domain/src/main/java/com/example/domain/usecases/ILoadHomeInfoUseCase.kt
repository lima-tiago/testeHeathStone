package com.example.domain.usecases

import com.example.commons.UseCase
import com.example.network.response.HomeInfoResponse

interface ILoadHomeInfoUseCase : UseCase.FromObservable.WithoutParameter<HomeInfoResponse>
