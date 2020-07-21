package com.example.testeandroidhearthstone.data.repositories

import com.example.testeandroidhearthstone.data.remote.ApiInterface
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse
import com.example.testeandroidhearthstone.domain.repositories.IHomeRepository
import io.reactivex.Observable

class HomeRepository(
    val apiClient: ApiInterface
) : IHomeRepository {
    override fun getInfo(): Observable<HomeInfoResponse> {
        return apiClient.getInfo()
    }
}