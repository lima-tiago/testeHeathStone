package com.example.testeandroidhearthstone.di

import androidx.room.Room
import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.HomeRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.IHomeRepository
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.data.repository.database.AppDatabase
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.ApiInterface
import org.koin.android.ext.koin.androidApplication

internal object DataModule {

    val module = org.koin.dsl.module {
        single<ICardsRepository> {
            CardsRepository(
                apiClient = get()
                ,
                cardDao = get()
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

        single<AppDatabase> {
            Room.databaseBuilder(get(), AppDatabase::class.java,"cards-db").fallbackToDestructiveMigration().build()
        }

        single<CardDao> { get<AppDatabase>().cardDao() }

//        single<ICardsRepository> { CardsRepository(get(),get()) }
//
    }
}