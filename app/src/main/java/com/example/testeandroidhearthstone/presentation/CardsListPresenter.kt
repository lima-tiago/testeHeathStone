package com.example.testeandroidhearthstone.presentation

import android.util.Log
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.CardImageResponse
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ScheduledExecutorService

class CardsListPresenter(private val view: CardsListContract.CardsListView) :
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
        return when (property) {
            "Sets" -> ApiClient.getClient().getCardsBySet(param)
            "Classes" -> ApiClient.getClient().getCardsByClass(param)
            "Races" -> ApiClient.getClient().getCardsByRaces(param)
            "Qualities" -> ApiClient.getClient().getCardsByQualities(param)
            "Types" -> ApiClient.getClient().getCardsByTypes(param)
            "Factions" -> ApiClient.getClient().getCardsByFactions(param)
            else -> null
        } as Observable<List<CardResponse>>
    }
}