package com.example.data.repositories

import com.example.network.response.HomeInfoResponse
import io.reactivex.Observable

interface IHomeRepository {
    fun getInfo(): Observable<HomeInfoResponse>

}
