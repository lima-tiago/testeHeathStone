package com.example.testeandroidhearthstone.data.repositories

import android.annotation.SuppressLint
import android.util.Log
import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.data.repositories.dao.CardDao
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.data.remote.ApiInterface
import com.example.testeandroidhearthstone.domain.repositories.ICardsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CardsRepository(
    val apiClient: ApiInterface,
    val cardDao: CardDao
) : ICardsRepository {

    override fun getCards(property: String, param: String): Observable<List<CardsResponse>> {
//        deleteAllCards()
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

    @SuppressLint("CheckResult")
    override fun insert(card: Card_Entity) {
        cardDao.insert(card)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava", "Insert Success") },
                { Log.d("RxJava", "Insert Error ${it.message}") }
            )
    }

    @SuppressLint("CheckResult")
    override fun getCardsWithId(): Observable<List<Card_Entity>> = cardDao.getCardsWithId()

    @SuppressLint("CheckResult")
    override fun deleteAllCards() {
        Completable.fromAction { cardDao.deleteAllCards() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("RxJava", "Delete Success")
            }
    }
//
//    override fun getAllCards(): Observable<List<Card>> = cardDao.getAllCards()
}