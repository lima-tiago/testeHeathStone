package com.example.testeandroidhearthstone.data.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testeandroidhearthstone.data.model.Card
import com.example.testeandroidhearthstone.data.repository.dao.CardDao
import com.example.testeandroidhearthstone.domain.entities.Card_Entity

@Database(entities = [(Card_Entity::class)],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun cardDao():CardDao
}