package com.example.testeandroidhearthstone.usecases

import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.rxjava3.core.Observable

class LoadHomeInfoUseCase(private val repository: ICardsRepository):ILoadHomeInfoUseCase {
    override fun execute(params: Boolean): Observable<InfoResponse> {
        return repository.getInfo()
    }
}