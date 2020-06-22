package com.example.testeandroidhearthstone.factory

import com.example.testeandroidhearthstone.data.model.ParentModel

object ParentDataFactory {

    private val listOfParent:List<String> = listOf(
        "Classes","Sets","Types","Factions","Qualities","Races")
//    private val listOfParent:List<String> = listOf(
//        "Classes","Sets","Standard","Wild","Types","Factions","Qualities","Races")

    fun getParents():List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        listOfParent.forEach {
            val parent =
                ParentModel(
                    it,
                    arrayListOf()
                )
            parents.add(parent)
            println(parent.title)
        }
        return parents
    }
}