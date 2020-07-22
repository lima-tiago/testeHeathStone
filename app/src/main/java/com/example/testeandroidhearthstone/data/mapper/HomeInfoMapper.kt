package com.example.testeandroidhearthstone.data.mapper

import com.example.testeandroidhearthstone.data.model.HomeInfo
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse

fun HomeInfoResponse.map(): List<HomeInfo>{
    val homeInfo = mutableListOf<HomeInfo>()

    this.run {
        homeInfo.add(HomeInfo(HomeInfoResponse::classes.name.capitalize(),classes))
        homeInfo.add(HomeInfo(HomeInfoResponse::sets.name.capitalize(),sets))
//        homeInfo.add(HomeInfo(HomeInfoResponse::standard.name.capitalize(),standard))
//        homeInfo.add(HomeInfo(HomeInfoResponse::wild.name.capitalize(),wild))
        homeInfo.add(HomeInfo(HomeInfoResponse::types.name.capitalize(),types))
        homeInfo.add(HomeInfo(HomeInfoResponse::factions.name.capitalize(),factions))
        homeInfo.add(HomeInfo(HomeInfoResponse::qualities.name.capitalize(),qualities))
        homeInfo.add(HomeInfo(HomeInfoResponse::races.name.capitalize(),races))
    }

    return homeInfo
}