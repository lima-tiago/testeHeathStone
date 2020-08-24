package com.example.domain.usecases

import com.example.data.repositories.IHomeRepository
import com.example.network.response.HomeInfoResponse
import io.reactivex.Observable

class LoadHomeInfoUseCase(private val repository: IHomeRepository):
    ILoadHomeInfoUseCase {

    override fun execute(): Observable<HomeInfoResponse> {
        return repository.getInfo()
    }

}