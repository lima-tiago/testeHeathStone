package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.domain.entities.Card_Entity

interface CardsListContract {

    interface CardsListView {
        fun getIncomingExtraProperty(): String
        fun getIncomingExtraParam(): String
        fun setUpAdapter(cards: List<com.example.testeandroidhearthstone.network.response.Card_Entity>)
        fun setTitle(param: String)

        fun showToast(message: String)
    }

    interface CardsListPresenter {
        fun getCards()

        fun insert(cardEntity: Card_Entity)
    }
}