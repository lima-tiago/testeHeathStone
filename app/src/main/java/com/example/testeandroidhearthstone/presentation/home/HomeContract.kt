package com.example.testeandroidhearthstone.presentation.home

import com.example.domain.model.HomeInfo

interface HomeContract {

    interface HomeView {
        fun setUpPropertyAdapter(homeInfoList: List<HomeInfo>)
        fun startShimmer()
        fun stopShimmer()
    }

    interface HomePresenter{
        fun getApiInfo()
    }
}