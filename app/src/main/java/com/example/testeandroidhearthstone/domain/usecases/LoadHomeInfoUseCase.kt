package com.example.testeandroidhearthstone.domain.usecases

import com.example.testeandroidhearthstone.domain.repositories.IHomeRepository
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse
import io.reactivex.Observable

class LoadHomeInfoUseCase(private val repository: IHomeRepository):ILoadHomeInfoUseCase {

    override fun execute(): Observable<HomeInfoResponse> {
        return repository.getInfo()
    }

}