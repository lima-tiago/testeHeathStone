package com.example.testeandroidhearthstone.data.di

import androidx.room.Room
import com.example.testeandroidhearthstone.data.repositories.CardsRepository
import com.example.testeandroidhearthstone.data.repositories.HomeRepository
import com.example.testeandroidhearthstone.domain.repositories.ICardsRepository
import com.example.testeandroidhearthstone.domain.repositories.IHomeRepository
import com.example.testeandroidhearthstone.data.remote.ApiClient
import com.example.testeandroidhearthstone.data.remote.ApiInterface

internal object DataModule {

    val module = org.koin.dsl.module {
        single<ICardsRepository> {
            CardsRepository(
                apiClient = get()
            )
        }

        single<IHomeRepository> {
            HomeRepository(
                apiClient = get()
            )
        }

        single<ApiInterface> {
            ApiClient.getClient()
        }
    }
}