package com.sevval.myapplication.Network


import io.reactivex.Observer
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

        @POST("/")
        fun sendRequest(@Body request: ApiRequest): Call<ApiResponse>

}
