package com.example.testeandroidhearthstone.presentation.home

import com.example.testeandroidhearthstone.data.model.ParentModel
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse

interface HomeContract {

    interface HomeView {

        fun setUpPropertyAdapter(resultInfo: HomeInfoResponse)
        fun startShimmer()
        fun stopShimmer()
    }

    interface HomePresenter{

        fun getApiInfo()
        fun newChildRecycler(parents: ParentModel, resultInfo: HomeInfoResponse): ParentModel
        fun setUpChildAdapterData(resultInfo: HomeInfoResponse):List<ParentModel>
    }
}