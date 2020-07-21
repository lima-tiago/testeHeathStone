package com.example.testeandroidhearthstone.presentation.di

import com.example.testeandroidhearthstone.presentation.cardsList.CardsListContract
import com.example.testeandroidhearthstone.presentation.cardsList.CardsListPresenter
import com.example.testeandroidhearthstone.presentation.home.HomeContract
import com.example.testeandroidhearthstone.presentation.home.HomePresenter
import org.koin.dsl.module

internal object PresentationModule {

    val module = module {
        factory<HomeContract.HomePresenter> { (view: HomeContract.HomeView) ->
            HomePresenter(
                view = view,
                loadHomeInfoUseCase = get()
            )
        }

        factory<CardsListContract.CardsListPresenter> { (view: CardsListContract.CardsListView) ->
            CardsListPresenter(
                view = view,
                repository = get(),
                loadCardsUseCase = get()
            )
        }

    }
}