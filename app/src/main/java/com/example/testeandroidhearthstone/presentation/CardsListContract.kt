package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.network.response.CardResponse
import retrofit2.Call

interface CardsListContract {

    interface CardsListView : BaseView<CardsListPresenter> {

        fun getIncommingExtraProperty(): String
        fun getIncommingExtraParam(): String
        fun setUpAdapter(cards: List<CardResponse>)
    }

    interface CardsListPresenter : BasePresenter {

        fun getCards(property: String, param: String)
        fun getCallType(property: String, param: String): Call<List<CardResponse>>?
    }
}