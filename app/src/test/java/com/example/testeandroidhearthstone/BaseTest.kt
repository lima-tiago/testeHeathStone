package com.example.testeandroidhearthstone

import android.os.Parcel
import android.os.Parcelable
import org.junit.After
import org.junit.Before
import org.koin.core.context.KoinContextHandler.start
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.KoinTest

//abstract class BaseTest() : KoinTest {
//    abstract val mockSetup: Module.() -> Unit
//
//    @Before
//    fun doBefore() {
//        TestSetup.start {
//            loadKoinModules(module { mockSetup(this) })
//        }
//    }
//
//    @After
//    fun doAfter() {
//        stopKoin()
//    }
//
//}