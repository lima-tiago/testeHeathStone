package com.example.testeandroidhearthstone.domain.repositories

import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse
import io.reactivex.Observable

interface IHomeRepository {
    fun getInfo(): Observable<HomeInfoResponse>

}
