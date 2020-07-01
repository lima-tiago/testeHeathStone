package com.example.testeandroidhearthstone.data.repository.dao

import androidx.room.*
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import io.reactivex.Completable

@Dao
interface CardDao {

    @Insert
    fun insert(card: Card_Entity): Completable

//    @Update
//    fun update(card: Card_Entity): Completable
//
//    @Delete
//    fun delete(card: Card_Entity): Completable
//
    @Query("DELETE FROM cards_table")
    fun deleteAllCards()
//
//    @Query("Select * FROM cards_table ORDER BY id DESC")
//    fun getAllCards(): Observable<List<Card_Entity>>

    //funcao que pega 10 imagens


}