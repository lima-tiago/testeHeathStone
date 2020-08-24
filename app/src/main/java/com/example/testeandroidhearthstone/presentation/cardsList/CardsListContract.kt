package com.example.testeandroidhearthstone.presentation.cardsList

import com.example.domain.model.Card

interface CardsListContract {

    interface CardsListView {
        fun getIncomingExtraProperty(): String
        fun getIncomingExtraParam(): String
        fun setUpAdapter(cards: List<Card>)
        fun setTitle(param: String)

        fun showToast(message: String)
    }

    interface CardsListPresenter {
        fun getCards()
    }
}