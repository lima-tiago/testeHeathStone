package com.example.testeandroidhearthstone.data.mapper

import com.example.testeandroidhearthstone.data.model.HomeInfo
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse

fun HomeInfoResponse.mxap(): List<HomeInfo>{
    val homeinfo = HomeInfo {
        classes.map { it }
    }

    return homeinfo.map{ it.map()}
}