package com.example.testeandroidhearthstone

import android.app.Application
import com.example.testeandroidhearthstone.di.AppModule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.mockito.Mockito.mock

object TestSetup {
    fun start(block: (KoinApplication) -> Unit) {
        setRxJavaTestSchedulers()

        val context: Application = mock()

        org.koin.core.context.startKoin {
            androidContext(context)
            val packages = listOf(AppModule)
            modules(packages.map { it.getModules() }.reduce { acc, list -> acc + list })
            block.invoke(this)
        }
    }

    private fun setRxJavaTestSchedulers() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }
}