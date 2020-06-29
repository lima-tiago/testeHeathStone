package com.example.testeandroidhearthstone.di

import org.koin.core.module.Module

object AppModule {

    fun getModule(): List<Module> = listOf(
        PresentationModule.module,
        DataModule.module,
        DomainModule.module
    )
}