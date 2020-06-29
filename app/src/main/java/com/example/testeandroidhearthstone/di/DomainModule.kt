package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.usecases.ILoadCardsUseCase
import com.example.testeandroidhearthstone.usecases.ILoadHomeInfoUseCase
import com.example.testeandroidhearthstone.usecases.LoadCardsUseCase
import com.example.testeandroidhearthstone.usecases.LoadHomeInfoUseCase
import org.koin.dsl.module

internal object DomainModule {

    val module = module {
        single<ILoadCardsUseCase> {
            LoadCardsUseCase(
                repository = get()
            )
        }

        single<ILoadHomeInfoUseCase> {
            LoadHomeInfoUseCase(
                repository = get()
            )
        }
    }
}