package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.data.ParentModel
import com.example.testeandroidhearthstone.network.response.InfoResponse

interface HomeContract {

    interface HomeView : BaseView<HomePresenter> {

//        fun setUpParentAdapter(children: List<Property>)
////        fun setUpChildrenAdapter()
////        fun addPropertyScroll(property: Property)
        fun setUpPropertyAdapter(resultInfo: InfoResponse)
    }

    interface HomePresenter : BasePresenter {

        fun getApiInfo()
        fun newChildRecycler(parents: ParentModel, resultInfo: InfoResponse): ParentModel
        fun setUpChildAdapterData(resultInfo: InfoResponse):List<ParentModel>
    }
}