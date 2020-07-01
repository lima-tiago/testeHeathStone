package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.network.ApiInterface
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.Observable

class HomeRepository(
    val apiClient: ApiInterface
) : IHomeRepository {
    override fun getInfo(): Observable<InfoResponse> {
        return apiClient.getInfo()
    }
}