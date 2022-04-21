package com.hegunhee.wirebarleytest.model

import com.hegunhee.wirebarleytest.BuildConfig
import com.hegunhee.wirebarleytest.data.USDRate
import com.hegunhee.wirebarleytest.util.RateAPI
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class TestRepository(private val rateApi : RateAPI) : Repository {
    override suspend fun getResponse(): Response<USDRate> {
        return rateApi.getUSDRate(BuildConfig.API_KEY).awaitResponse()
    }

}