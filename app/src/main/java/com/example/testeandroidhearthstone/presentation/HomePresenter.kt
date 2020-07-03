package com.example.testeandroidhearthstone.presentation

import android.util.Log
import com.example.testeandroidhearthstone.data.model.ParentModel
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.IHomeRepository
import com.example.testeandroidhearthstone.factory.ParentDataFactory
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.InfoResponse
import com.example.testeandroidhearthstone.usecases.ILoadHomeInfoUseCase
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers.io

class HomePresenter(
    private val view: HomeContract.HomeView,
    private val loadHomeInfoUseCase: ILoadHomeInfoUseCase
) : HomeContract.HomePresenter {

    private val TAG = "homepresenter"

    override fun getApiInfo() {
        view.showLoading()
        loadHomeInfoUseCase.execute(true)
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<InfoResponse> {
                override fun onComplete() {
                    Log.d(TAG, "Completed")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "Subscribed")
                }

                override fun onNext(t: InfoResponse) {
                    Log.d(TAG, "Next")
                    view.setUpPropertyAdapter(t)
                    view.hideLoading()
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error")
                }
            })
    }

    override fun setUpChildAdapterData(resultInfo: InfoResponse): List<ParentModel> {
        val parentList = mutableListOf<ParentModel>()
        ParentDataFactory.getParents().forEach {
            parentList.add(newChildRecycler(it, resultInfo))
        }
        return parentList
    }

    override fun newChildRecycler(parent: ParentModel, resultInfo: InfoResponse): ParentModel {
        when (parent.title) {
            "Classes" -> parent.children.addAll(resultInfo.classes)
            "Sets" -> parent.children.addAll(resultInfo.sets)
            "Types" -> parent.children.addAll(resultInfo.types)
            "Factions" -> parent.children.addAll(resultInfo.factions)
            "Qualities" -> parent.children.addAll(resultInfo.qualities)
            "Races" -> parent.children.addAll(resultInfo.races)
            else -> {
            }
        }
        return parent
    }
}