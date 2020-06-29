package com.example.testeandroidhearthstone.presentation

import android.util.Log
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.usecases.ILoadCardsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CardsListPresenter(
    private val view: CardsListContract.CardsListView,
    private val repository: ICardsRepository,
    private val loadCardsUseCase: ILoadCardsUseCase
) :
    CardsListContract.CardsListPresenter {


    private val TAG = "cardspresenter"

    override fun getCards(property: String, param: String) {
        view.setTitle(param)
//        loadCardsUseCase
        repository.getCards(property, param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<CardResponse>> {
                override fun onComplete() {
                    Log.d(TAG, "Completed")
                }

                override fun onSubscribe(d: Disposable?) {
                    Log.d(TAG, "Subscribed")
                }

                override fun onNext(t: List<CardResponse>) {
                    view.setUpAdapter(t)
                }

                override fun onError(e: Throwable?) {
                    Log.d(TAG, "Error")
                }
            })
    }
}
