package com.example.testeandroidhearthstone.data.repository

import com.example.testeandroidhearthstone.data.model.Card
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

class CardsRepository(
    val apiClient:ApiInterface,
    val cardDao: CardDao
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


    override fun insert(card: Card) {
        TODO("Not yet implemented")
    }

    override fun update(card: Card) {
        TODO("Not yet implemented")
    }

    override fun delete(card: Card) {
        TODO("Not yet implemented")
    }

    override fun deleteAllCards() {
        TODO("Not yet implemented")
    }

    override fun getAllCards(): Observable<List<Card>> {
        TODO("Not yet implemented")
    }
}