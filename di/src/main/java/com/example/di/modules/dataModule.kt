package com.example.di.modules

import com.example.data.repository.AddressRepositoryImpl
import com.example.domain.repository.AddressRepository
import org.koin.dsl.module

val dataModule = module {
    single<AddressRepository> { AddressRepositoryImpl(get()) }
}