package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call

interface CardsListContract {

    interface CardsListView : BaseView<CardsListPresenter> {

        fun getIncomingExtraProperty(): String
        fun getIncomingExtraParam(): String
        fun setUpAdapter(cards: List<CardResponse>)
    }

    interface CardsListPresenter : BasePresenter {

        fun getCards(property: String, param: String)
        fun getCallType(property: String, param: String): Observable<List<CardResponse>>?
    }
}