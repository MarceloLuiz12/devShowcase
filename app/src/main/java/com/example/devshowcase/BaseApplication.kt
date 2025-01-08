package com.example.devshowcase

import android.app.Application
import com.example.di.modules.domainModule
import com.example.di.modules.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            modules(
                listOf(
                    navigationModule,
                    domainModule
                )
            )
            androidContext(applicationContext)
        }
    }
}