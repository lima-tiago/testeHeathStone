package com.example.data.repositories

import com.example.network.remote.ApiInterface
import com.example.network.response.CardResponse
import io.reactivex.Observable

class CardsRepository(
    val apiClient: ApiInterface
) : ICardsRepository {

    override fun getCards(property: String, param: String): Observable<List<CardResponse>> {
        return when (property) {
            "Sets" -> apiClient.getCardsBySet(param)
            "Classes" -> apiClient.getCardsByClass(param)
            "Races" -> apiClient.getCardsByRaces(param)
            "Qualities" -> apiClient.getCardsByQualities(param)
            "Types" -> apiClient.getCardsByTypes(param)
            "Factions" -> apiClient.getCardsByFactions(param)
            "Standard" -> apiClient.getCardsByFactions(param)
            "Wild" -> apiClient.getCardsByFactions(param)
            else -> null
        } as Observable<List<CardResponse>>
    }
}