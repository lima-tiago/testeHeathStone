package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.CardsActivityList
import com.example.testeandroidhearthstone.HomeActivity
import com.example.testeandroidhearthstone.presentation.CardsListContract
import com.example.testeandroidhearthstone.presentation.CardsListPresenter
import com.example.testeandroidhearthstone.presentation.HomeContract
import com.example.testeandroidhearthstone.presentation.HomePresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal object PresentationModule {

    val module = module {
        factory<HomeContract.HomePresenter> { (view: HomeContract.HomeView) ->
            HomePresenter(
                view = view,
                repository = get(),
                loadHomeInfoUseCase = get()
            )
        }

//        factory<CardsListContract.CardsListPresenter> { (view: CardsListContract.CardsListView) ->
//            CardsListPresenter(
//                view = view,
//                repository = get(),
//                loadCardsUseCase = get(),
//                interactor = get()
//            )
//        }

        viewModel {(view: CardsActivityList) ->
            CardsListPresenter(
            view = view,
            repository = get(),
            loadCardsUseCase = get()
        ) }
    }
}