package com.example.data.repositories

interface ISharedPreferences   {

    fun clearPrefs()
    fun addCardToPrefs()
    fun getCardFromPrefs()
}