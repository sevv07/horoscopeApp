package com.sevval.myapplication.Network

data class ApiResponse(
    val id :Int,
    val date: String,
    val horoscope: String,
    val icon: String,
    val sign:String
) {
}