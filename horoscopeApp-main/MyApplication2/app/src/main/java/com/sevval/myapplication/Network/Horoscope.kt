package com.sevval.myapplication.Network

import com.google.gson.annotations.SerializedName

data class Horoscope(
    @SerializedName("sign")
    val sign: String="",
    @SerializedName("period")
    val period: String="",
    @SerializedName("general")
    val general: String=""
)