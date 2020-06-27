package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.core.Observable

class CardsRepository(
    val apiClient:ApiClient
): ICardsRepository {

    init {

    }
    override fun getCardsBySet(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsBySet(param)
    }

    override fun getCardsByClass(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsByClass(param)
    }

    override fun getCardsByRaces(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsByRaces(param)
    }

    override fun getCardsByQualities(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsByQualities(param)
    }

    override fun getCardsByTypes(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsByTypes(param)
    }

    override fun getCardsByFactions(param: String): Observable<List<CardResponse>> {
        return apiClient.getClient().getCardsByFactions(param)
    }
//    override fun getCardsBySet(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsBySet(param)
//    }
//
//    override fun getCardsByClass(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsByClass(param)
//    }
//
//    override fun getCardsByRaces(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsByRaces(param)
//    }
//
//    override fun getCardsByQualities(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsByQualities(param)
//    }
//
//    override fun getCardsByTypes(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsByTypes(param)
//    }
//
//    override fun getCardsByFactions(param: String): Observable<List<CardResponse>> {
//        return ApiClient.getClient().getCardsByFactions(param)
//    }
}