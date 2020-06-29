package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

class CardsRepository(
    val apiClient:ApiInterface
): ICardsRepository {

    override fun getInfo(): Observable<InfoResponse> {
        return apiClient.getInfo()
    }

    override fun getCards(property: String, param: String): Observable<List<CardResponse>> {
        return when (property){
            "Sets" -> apiClient.getCardsBySet(param)
            "Classes" -> apiClient.getCardsByClass(param)
            "Races" -> apiClient.getCardsByRaces(param)
            "Qualities" -> apiClient.getCardsByQualities(param)
            "Types" -> apiClient.getCardsByTypes(param)
            "Factions" -> apiClient.getCardsByFactions(param)
            else -> null
        } as Observable<List<CardResponse>>
    }


}