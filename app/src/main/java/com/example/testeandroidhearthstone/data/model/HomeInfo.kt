package com.example.testeandroidhearthstone.data.model


data class HomeInfo(
    var classes: List<String>,
    var sets: List<String>,
    var standard: List<String>,
    var wild: List<String>,
    var types: List<String>,
    var factions: List<String>,
    var qualities: List<String>,
    var races: List<String>
)