package com.example.testeandroidhearthstone.data.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.domain.entities.Card

@Database(entities = [com.example.testeandroidhearthstone.data.model.Card::class],version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun cardDao():CardDao
}