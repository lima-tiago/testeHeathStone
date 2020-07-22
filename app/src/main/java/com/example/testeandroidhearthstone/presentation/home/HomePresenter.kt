package com.example.testeandroidhearthstone.presentation.home

import android.util.Log
import com.example.testeandroidhearthstone.data.mapper.map
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
                    t.map().let {
                        view.setUpPropertyAdapter(it)
                    }
                    view.stopShimmer()
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error")
                }
            })
    }
}