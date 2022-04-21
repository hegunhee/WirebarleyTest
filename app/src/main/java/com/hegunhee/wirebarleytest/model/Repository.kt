package com.hegunhee.wirebarleytest.model

import com.hegunhee.wirebarleytest.data.USDRate
import retrofit2.Response

interface Repository {

    suspend fun getResponseBody() : Response<USDRate>
}