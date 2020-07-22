package com.example.testeandroidhearthstone.commons

import com.example.testeandroidhearthstone.data.model.response.CardsResponse
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import io.reactivex.Completable
import io.reactivex.Observable

abstract class UseCase {

    object FromObservable {

        interface WithParameter<in P, R> {
            fun execute(params: P): Observable<List<CardsResponse>>
        }

        interface WithoutParameter<R> {
            fun execute(): Observable<R>
        }
    }

    object FromCompletable {

        interface WithParameter<in P> {
            fun execute(params: P): Completable
        }

        interface WithoutParameter {
            fun execute(): Completable
        }
    }
}