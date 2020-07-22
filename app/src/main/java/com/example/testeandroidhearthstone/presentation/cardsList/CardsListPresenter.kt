package com.example.testeandroidhearthstone.presentation.cardsList

import android.util.Log
import com.example.testeandroidhearthstone.data.mapper.map
import com.example.testeandroidhearthstone.data.model.request.CardsRequest
import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.usecases.ILoadCardsUseCase
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CardsListPresenter(
    private val view: CardsListContract.CardsListView,
    private val loadCardsUseCase: ILoadCardsUseCase
) :
    CardsListContract.CardsListPresenter {

    private val TAG = "cardspresenter"

    override fun getCards() {
        val params =
            CardsRequest(
                view.getIncomingExtraProperty(),
                view.getIncomingExtraParam()
            )
        view.setTitle(params.param)
        loadCardsUseCase.execute(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<CardsResponse>> {
                override fun onComplete() {
                    Log.d(TAG, "Completed")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "Subscribed")
                }

                override fun onNext(t: List<CardsResponse>) {
                    println("Hello finished")

                    t.map().let {
                        view.setUpAdapter(it)
                        it.forEach {
                            Log.d(TAG, it.cardId)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error")
                }
            })
    }
}