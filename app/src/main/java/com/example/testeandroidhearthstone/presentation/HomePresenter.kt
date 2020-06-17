package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.data.ParentModel
import com.example.testeandroidhearthstone.factory.ParentDataFactory
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.InfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeContract.HomeView) : HomeContract.HomePresenter {

    init {
        this.view.setPresenter(this)
//        view.setUpParentAdapter()
    }

    override fun start() {}

    override fun getApiInfo() {
        val call: Call<InfoResponse> = ApiClient.getClient().getInfo()

        call.enqueue(object : Callback<InfoResponse> {
            override fun onResponse(call: Call<InfoResponse>, response: Response<InfoResponse>) {
                val resultInfo:InfoResponse = response.body()!!
                view.setUpPropertyAdapter(resultInfo)
            }

            override fun onFailure(call: Call<InfoResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun setUpChildAdapterData(resultInfo: InfoResponse):List<ParentModel> {
        val parentList = mutableListOf<ParentModel>()
        ParentDataFactory.getParents().forEach {
            parentList.add(newChildRecycler(it,resultInfo))
        }
        return parentList
    }

    override fun newChildRecycler(parent: ParentModel, resultInfo: InfoResponse):ParentModel {
        when(parent.title){
            "Classes"-> parent.children.addAll(resultInfo.classes)
            "Sets"->parent.children.addAll(resultInfo.sets)
//            "Standard"->parent.children.addAll(resultInfo.standard)
//            "Wild"->parent.children.addAll(resultInfo.wild)
            "Types"->parent.children.addAll(resultInfo.types)
            "Factions"->parent.children.addAll(resultInfo.factions)
            "Qualities"->parent.children.addAll(resultInfo.qualities)
            "Races"->parent.children.addAll(resultInfo.races)
            else -> { }
        }

        return parent
    }
}