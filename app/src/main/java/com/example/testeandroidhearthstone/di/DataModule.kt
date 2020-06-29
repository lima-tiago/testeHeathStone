package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface

internal object DataModule {

    val module = org.koin.dsl.module {
        factory<ICardsRepository> {
            CardsRepository(
                get()
            )
        }

        single<ApiInterface> {
            ApiClient.getClient()
        }
    }
}