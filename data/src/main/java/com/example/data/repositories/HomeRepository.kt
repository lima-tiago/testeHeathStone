package com.example.data.repositories

import com.example.network.remote.ApiInterface
import com.example.network.response.HomeInfoResponse
import io.reactivex.Observable

class HomeRepository(
    val apiClient: ApiInterface
) : IHomeRepository {
    override fun getInfo(): Observable<HomeInfoResponse> {
        return apiClient.getInfo()
    }
}