package com.example.testeandroidhearthstone.data.repositories.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testeandroidhearthstone.data.repositories.dao.CardDao
import com.example.testeandroidhearthstone.domain.entities.Card_Entity

@Database(entities = [(Card_Entity::class)],version = 2,exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun cardDao():CardDao
}