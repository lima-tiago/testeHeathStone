package com.example.testeandroidhearthstone.data.repository.dao

import androidx.room.*
import com.example.testeandroidhearthstone.domain.entities.Card
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface CardDao {

    @Insert
    fun insert(card: Card): Completable

    @Update
    fun update(card: Card): Completable

    @Delete
    fun delete(card: Card): Completable

    @Query("DELETE FROM cards_table")
    fun deleteAllCards()

    @Query("Select * FROM cards_table ORDER BY id DESC")
    fun getAllCards(): Observable<List<Card>>

    //funcao que pega 10 imagens


}