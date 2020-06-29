package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.data.model.ParentModel
import com.example.testeandroidhearthstone.network.response.InfoResponse

interface HomeContract {

    interface HomeView {

        fun setUpPropertyAdapter(resultInfo: InfoResponse)
        fun hideLoading()
        fun showLoading()
    }

    interface HomePresenter{

        fun getApiInfo()
        fun newChildRecycler(parents: ParentModel, resultInfo: InfoResponse): ParentModel
        fun setUpChildAdapterData(resultInfo: InfoResponse):List<ParentModel>
    }
}