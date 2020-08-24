package com.example.domain.di

import com.example.domain.usecases.ILoadCardsUseCase
import com.example.domain.usecases.ILoadHomeInfoUseCase
import com.example.domain.usecases.LoadCardsUseCase
import com.example.domain.usecases.LoadHomeInfoUseCase
import org.koin.dsl.module

object DomainModule {

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