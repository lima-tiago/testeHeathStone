package com.example.testeandroidhearthstone.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards_table")
data class Card_Entity(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "card_id") var cardId: String,
    @ColumnInfo(name = "img") var img: String?,
    @ColumnInfo(name = "locale") var locale: String,
    @ColumnInfo(name = "type") var type: String

)
