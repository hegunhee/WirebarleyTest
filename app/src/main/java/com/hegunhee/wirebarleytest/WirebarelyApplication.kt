package com.hegunhee.wirebarleytest

import android.app.Application
import com.hegunhee.wirebarleytest.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class WirebarelyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@WirebarelyApplication)
            androidFileProperties()
            modules(listOf(mainModule))
        }
    }
}