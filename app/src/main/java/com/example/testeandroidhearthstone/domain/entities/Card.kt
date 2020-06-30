package com.example.testeandroidhearthstone.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards_table")
data class Card(
    @PrimaryKey(autoGenerate = true) var id :Int,
    @ColumnInfo(name = "cardId") val cardId: String,
    @ColumnInfo(name = "cardSet") val cardSet: String,
    @ColumnInfo(name = "cost") val cost: Int,
    @ColumnInfo(name = "dbfId") val dbfId: String,
    @ColumnInfo(name = "faction") val faction: String,
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "imgGold") val imgGold: String,
    @ColumnInfo(name = "locale") val locale: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "playerClass") val playerClass: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "type") val type: String

    )