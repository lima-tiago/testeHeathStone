package com.example.testeandroidhearthstone.presentation

import android.util.Log
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.ISharedPreferences
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.ScheduledExecutorService

class CardsListPresenter(
    private val view: CardsListContract.CardsListView,
    private val sharedPrefs: ISharedPreferences,
    private val repository: ICardsRepository
) :
    CardsListContract.CardsListPresenter {

    init {
        this.view.setPresenter(this)
    }

    private val TAG = "cardspresenter"
    override fun start() {}

    override fun getCards(property: String, param: String) {
        getCallType(property,param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( object: Observer<List<CardResponse>> {
                override fun onComplete() {
                    Log.d(TAG,"Completed")
                }

                override fun onSubscribe(d: Disposable?) {
                    Log.d(TAG,"Subscribed")
                }

                override fun onNext(t: List<CardResponse>) {
                    view.setUpAdapter(t)
                }

                override fun onError(e: Throwable?) {
                    Log.d(TAG,"Error")
                }
            })
    }

    override fun getCallType(property: String, param: String): Observable<List<CardResponse>> {

        // move the 'when' to repository and call only getCards with property and param as variables
        return when (property) {
            "Sets" -> repository.getCardsBySet(param)
            "Classes" -> repository.getCardsByClass(param)
            "Races" -> repository.getCardsByRaces(param)
            "Qualities" -> repository.getCardsByQualities(param)
            "Types" -> repository.getCardsByTypes(param)
            "Factions" -> repository.getCardsByFactions(param)
            else -> null
        } as Observable<List<CardResponse>>
    }
}


//"Sets" -> ApiClient.getClient().getCardsBySet(param)
//"Classes" -> ApiClient.getClient().getCardsByClass(param)
//"Races" -> ApiClient.getClient().getCardsByRaces(param)
//"Qualities" -> ApiClient.getClient().getCardsByQualities(param)
//"Types" -> ApiClient.getClient().getCardsByTypes(param)
//"Factions" -> ApiClient.getClient().getCardsByFactions(param)