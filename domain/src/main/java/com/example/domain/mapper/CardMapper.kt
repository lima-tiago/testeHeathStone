package com.example.domain.mapper

import com.example.network.response.CardResponse
import com.example.domain.model.Card

fun List<CardResponse>.map(): List<Card> {
    val cards = mutableListOf<Card>()

    this.forEach {
        cards.add(
            Card(
                cardId = it.cardId,
                img = "https://art.hearthstonejson.com/v1/render/latest/${it.locale}/256x/${it.cardId}.png",
                locale = it.locale,
                type = it.type
            )
        )
    }

    return cards
}