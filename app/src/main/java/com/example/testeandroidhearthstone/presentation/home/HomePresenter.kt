package com.example.testeandroidhearthstone.presentation.home

import android.util.Log
import com.example.testeandroidhearthstone.data.model.ParentModel
import com.example.testeandroidhearthstone.factory.ParentDataFactory
import com.example.testeandroidhearthstone.data.model.response.HomeInfoResponse
import com.example.testeandroidhearthstone.domain.usecases.ILoadHomeInfoUseCase
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
        view.startShimmer()
        loadHomeInfoUseCase.execute()
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeInfoResponse> {
                override fun onComplete() {
                    Log.d(TAG, "Completed")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "Subscribed")
                }

                override fun onNext(t: HomeInfoResponse) {
                    Log.d(TAG, "Next")
                    view.setUpPropertyAdapter(t)
                    view.stopShimmer()
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error")
                }
            })
    }

    override fun setUpChildAdapterData(resultInfo: HomeInfoResponse): List<ParentModel> {
        val parentList = mutableListOf<ParentModel>()
        ParentDataFactory.getParents().forEach {
            parentList.add(newChildRecycler(it, resultInfo))
        }
        return parentList
    }

    override fun newChildRecycler(parent: ParentModel, resultInfo: HomeInfoResponse): ParentModel {
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