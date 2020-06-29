package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.network.response.CardResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call

interface CardsListContract {

    interface CardsListView {
        fun getIncomingExtraProperty(): String
        fun getIncomingExtraParam(): String
        fun setUpAdapter(cards: List<CardResponse>)
        fun setTitle(param: String)
    }

    interface CardsListPresenter  {
        fun getCards(property: String, param: String)
    }
}