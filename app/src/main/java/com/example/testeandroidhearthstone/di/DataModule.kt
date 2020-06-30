package com.example.testeandroidhearthstone.di

import androidx.room.Room
import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.data.repository.database.AppDatabase
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import org.koin.android.ext.koin.androidApplication

internal object DataModule {

    val module = org.koin.dsl.module {
        factory<ICardsRepository> {
            CardsRepository(
                apiClient = get(),
                cardDao = get()
            )
        }

        single<ApiInterface> {
            ApiClient.getClient()
        }

        single<CardDao> {
            Room.databaseBuilder(androidApplication(),AppDatabase::class.java,"cards-db").build().cardDao()
        }

        single { get<AppDatabase>().cardDao() }

    }
}