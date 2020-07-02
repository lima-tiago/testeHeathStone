package com.example.testeandroidhearthstone.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.usecases.ILoadCardsUseCase
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CardsListPresenter(
    private val view: CardsListContract.CardsListView,
    private val repository: ICardsRepository,
    private val loadCardsUseCase: ILoadCardsUseCase
) :
    CardsListContract.CardsListPresenter , ViewModel(){

    private val TAG = "cardspresenter"

    override fun getCards() {
        val param = view.getIncomingExtraParam()
        val property = view.getIncomingExtraProperty()
        view.setTitle(param)
//        loadCardsUseCase

        repository.deleteAllCards()
        repository.getCards(property, param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Card_Entity>> {
                override fun onComplete() {
                    Log.d(TAG, "Completed")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "Subscribed")
                }

                override fun onNext(t: List<Card_Entity>) {
                    view.showToast("finished fetching")
                    println("Hello finished")
                    t.forEach {
                        val card = Card_Entity(
                            null,
                            it.cardId,
                            it.img,
                            it.imgGold,
                            it.locale,
                            it.type
                        )
                        insert(card)
                    }
                    getCardsWithId()
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error")
                }
            })
    }

    @SuppressLint("CheckResult")
    override fun getCardsWithId() {
        repository.getCardsWithId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list -> view.setUpAdapter(list) }
            )
    }

    override fun insert(cardEntity: Card_Entity) = repository.insert(cardEntity)

}