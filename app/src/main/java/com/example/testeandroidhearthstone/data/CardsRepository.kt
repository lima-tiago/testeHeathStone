package com.example.testeandroidhearthstone.data

import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.core.Observable

class CardsRepository(
    val api:ApiInterface
):ICardsRepository {

    override fun getCards(property: String, param: String) {
        TODO("Not yet implemented")
    }

    override fun getCardsBySet(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByClass(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByRaces(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByQualities(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByTypes(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
    }

    override fun getCardsByFactions(param: String): Observable<List<CardResponse>> {
        TODO("Not yet implemented")
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