package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import org.koin.dsl.module

internal object Module {

    val module = module {
        single<ICardsRepository> {
            CardsRepository(
                apiClient = get()
            )
        }
    }
}