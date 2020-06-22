package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.data.CardsRepository
import com.example.testeandroidhearthstone.data.ICardsRepository
import org.koin.dsl.module

internal object Module {

    val module = module {
        single<ICardsRepository> {
            CardsRepository(
                api = get()
            )
        }
    }
}