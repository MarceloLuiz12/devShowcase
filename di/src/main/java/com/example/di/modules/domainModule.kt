package com.example.di.modules

import com.example.domain.core.ThreadContextProvider
import com.example.domain.usecase.GetAddressUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        GetAddressUseCase(
            scope = scope,
            repository = get()
        )
    }
}