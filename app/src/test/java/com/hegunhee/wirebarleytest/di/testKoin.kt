package com.hegunhee.wirebarleytest.di

import com.hegunhee.wirebarleytest.model.TestRepository
import com.hegunhee.wirebarleytest.util.getRateApi
import org.koin.dsl.module

val testModule = module {


    single { TestRepository(get()) }
    single { getRateApi() }
}