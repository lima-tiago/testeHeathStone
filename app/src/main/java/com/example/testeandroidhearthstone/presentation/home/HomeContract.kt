package com.example.testeandroidhearthstone.presentation.home

import com.example.testeandroidhearthstone.data.model.HomeInfo

interface HomeContract {

    interface HomeView {
        fun setUpPropertyAdapter(resultInfo: List<HomeInfo>)
        fun startShimmer()
        fun stopShimmer()
    }

    interface HomePresenter{

        fun getApiInfo()
    }
}