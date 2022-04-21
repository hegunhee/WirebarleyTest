package com.hegunhee.wirebarleytest.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRateApi(): RateAPI = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(RateAPI::class.java)


const val BASE_URL = "http://api.currencylayer.com"