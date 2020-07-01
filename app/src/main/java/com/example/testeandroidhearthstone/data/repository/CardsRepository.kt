package com.example.testeandroidhearthstone.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.network.ApiInterface
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CardsRepository(
    val apiClient: ApiInterface
    ,
    val cardDao: CardDao
) : ICardsRepository {


    override fun getCards(property: String, param: String): Observable<List<Card_Entity>> {
        return when (property) {
            "Sets" -> apiClient.getCardsBySet(param)
            "Classes" -> apiClient.getCardsByClass(param)
            "Races" -> apiClient.getCardsByRaces(param)
            "Qualities" -> apiClient.getCardsByQualities(param)
            "Types" -> apiClient.getCardsByTypes(param)
            "Factions" -> apiClient.getCardsByFactions(param)
            else -> null
        } as Observable<List<Card_Entity>>
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
//
//    override fun update(card: com.example.testeandroidhearthstone.domain.entities.Card) {
//        TODO("Not yet implemented")
//    }
//
//    override fun delete(card: com.example.testeandroidhearthstone.domain.entities.Card) {
//        TODO("Not yet implemented")
//    }
//
    @SuppressLint("CheckResult")
    override fun deleteAllCards() {
        Completable.fromAction { cardDao.deleteAllCards() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("RxJava" ,"Delete Success")
            }
}
//
//    override fun getAllCards(): Observable<List<Card>> = cardDao.getAllCards()
}