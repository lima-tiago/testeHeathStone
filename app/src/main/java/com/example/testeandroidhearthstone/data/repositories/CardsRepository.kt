package com.example.testeandroidhearthstone.data.repositories

import android.annotation.SuppressLint
import android.util.Log
import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.data.remote.ApiInterface
import com.example.testeandroidhearthstone.domain.repositories.ICardsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CardsRepository(
    val apiClient: ApiInterface
) : ICardsRepository {

    override fun getCards(property: String, param: String): Observable<List<CardsResponse>> {

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
        } as Observable<List<CardsResponse>>
    }
}