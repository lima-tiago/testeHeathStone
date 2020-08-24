package com.example.data.di

import com.example.data.repositories.CardsRepository
import com.example.data.repositories.HomeRepository
import com.example.network.remote.ApiClient
import com.example.network.remote.ApiInterface
import com.example.data.repositories.ICardsRepository
import com.example.data.repositories.IHomeRepository
import org.koin.dsl.module

object DataModule {

    val module = module {
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