package com.example.testeandroidhearthstone.data.mapper

import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.entities.Card_Entity

fun List<CardsResponse>.map(): List<Card_Entity> {
    val cards = mutableListOf<Card_Entity>()

    this.forEach {
        cards.add(
            Card_Entity(
                null,
                it.cardId,
                "https://art.hearthstonejson.com/v1/render/latest/${it.locale}/256x/${it.cardId}.png",
                it.locale,
                it.type
            )
        )
    }

    return cards
}