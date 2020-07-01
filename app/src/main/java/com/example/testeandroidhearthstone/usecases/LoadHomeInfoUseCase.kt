package com.example.testeandroidhearthstone.usecases

import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.IHomeRepository
import com.example.testeandroidhearthstone.network.response.InfoResponse
import io.reactivex.Observable

class LoadHomeInfoUseCase(private val repository: IHomeRepository):ILoadHomeInfoUseCase {
    override fun execute(params: Boolean): Observable<InfoResponse> {
        return repository.getInfo()
    }
}