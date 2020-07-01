package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.Observable

interface IHomeRepository {
    fun getInfo(): Observable<InfoResponse>

}
