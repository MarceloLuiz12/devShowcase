package com.example.devshowcase

import android.app.Application
import com.example.di.modules.dataModule
import com.example.di.modules.dataRemoteModule
import com.example.di.modules.domainModule
import com.example.di.modules.navigationModule
import com.example.di.modules.presentationModule
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
                    domainModule,
                    dataModule,
                    dataRemoteModule,
                    presentationModule
                )
            )
            androidContext(applicationContext)
        }
    }
}