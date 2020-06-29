package com.example.testeandroidhearthstone.commons

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

abstract class UseCase {

    object FromObservable {

        interface WithParameter<in P, R> {
            fun execute(params: P): Observable<R>
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