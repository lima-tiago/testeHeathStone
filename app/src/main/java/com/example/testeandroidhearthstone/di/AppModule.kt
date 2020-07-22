package com.example.testeandroidhearthstone.di

import com.example.testeandroidhearthstone.data.di.DataModule
import com.example.testeandroidhearthstone.domain.di.DomainModule
import com.example.testeandroidhearthstone.presentation.di.PresentationModule
import org.koin.core.module.Module

object AppModule {

    fun getModules(): List<Module> = listOf(
        PresentationModule.module,
        DataModule.module,
        DomainModule.module
    )
}