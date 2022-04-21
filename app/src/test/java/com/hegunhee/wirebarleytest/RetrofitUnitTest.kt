package com.hegunhee.wirebarleytest

import com.hegunhee.wirebarleytest.util.getRateApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.*

class RetrofitUnitTest {

    @Test
    fun `test retrofit`() = runBlocking {
        launch(Dispatchers.IO) {
            println("진입")
            val api = getRateApi()
            println("진입 그다음")
            api.getUSDRate(BuildConfig.API_KEY).awaitResponse().body()?.run {
                println(quotes)
            }
        }.join()

    }
}