package com.sevval.myapplication.Network

import org.checkerframework.checker.units.qual.C
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class  RetrofitInstance {
 companion object{



     val api: Api by lazy{
         Retrofit.Builder()
             .baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
             .create(Api::class.java)
     }
 }



 }


