package com.example.testeandroidhearthstone.domain.repositories

interface ISharedPreferences   {

    fun clearPrefs()
    fun addCardToPrefs()
    fun getCardFromPrefs()
}