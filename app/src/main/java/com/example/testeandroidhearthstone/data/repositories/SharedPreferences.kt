package com.example.testeandroidhearthstone.data.repositories

import android.content.Context
import android.content.SharedPreferences
import com.example.testeandroidhearthstone.domain.repositories.ISharedPreferences

class SharedPreferences(context: Context) :
    ISharedPreferences {
    private var mSharedPreferences : SharedPreferences? = null
    private val CARDS = "cards"
    private val PREF_FILE = "prefs"

    init {
        if(mSharedPreferences == null) {
            mSharedPreferences =
                context.getSharedPreferences(PREF_FILE,Context.MODE_PRIVATE) ?: mSharedPreferences
        }
    }

    override fun clearPrefs() {
        mSharedPreferences?.edit()?.clear()
    }

    override fun addCardToPrefs() {
        TODO("Not yet implemented")
    }

    override fun getCardFromPrefs() {
        TODO("Not yet implemented")
    }
}