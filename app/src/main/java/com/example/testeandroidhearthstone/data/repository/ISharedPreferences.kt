package com.example.testeandroidhearthstone.data.repository

interface ISharedPreferences   {

    fun clearPrefs()
    fun addCardToPrefs()
    fun getCardFromPrefs()
}