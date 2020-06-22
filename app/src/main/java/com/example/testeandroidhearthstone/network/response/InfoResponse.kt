package com.example.testeandroidhearthstone.network.response

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("patch") var patch: String,
    @SerializedName("classes") var classes: List<String>,
    @SerializedName("sets") var sets: List<String>,
    @SerializedName("standard") var standard: List<String>,
    @SerializedName("wild") var wild: List<String>,
    @SerializedName("types") var types: List<String>,
    @SerializedName("factions") var factions: List<String>,
    @SerializedName("qualities") var qualities: List<String>,
    @SerializedName("races") var races: List<String>,
    @SerializedName("locales") var locales: List<String>
)