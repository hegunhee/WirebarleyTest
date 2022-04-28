package com.hegunhee.wirebarleytest.util

import com.hegunhee.wirebarleytest.data.USDRate
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RateAPI {
    @GET("/live")
    suspend fun getUSDRate(
        @Query("access_key") key : String,
        @Query("currencies") country : String = "KRW,JPY,PHP",
    ) : Call<USDRate>
}