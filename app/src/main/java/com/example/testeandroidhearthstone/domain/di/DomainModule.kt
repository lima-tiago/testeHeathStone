package com.example.testeandroidhearthstone.domain.di

import com.example.testeandroidhearthstone.domain.usecases.ILoadCardsUseCase
import com.example.testeandroidhearthstone.domain.usecases.ILoadHomeInfoUseCase
import com.example.testeandroidhearthstone.domain.usecases.LoadCardsUseCase
import com.example.testeandroidhearthstone.domain.usecases.LoadHomeInfoUseCase
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