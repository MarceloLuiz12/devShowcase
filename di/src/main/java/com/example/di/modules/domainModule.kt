package com.example.di.modules

import com.example.domain.core.ThreadContextProvider
import org.koin.dsl.module

val domainModule = module {
    single {
        ThreadContextProvider()
    }
}