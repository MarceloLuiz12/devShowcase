package com.example.di.modules

import com.example.data.remote.AddressDataRemoteDataSource
import com.example.data_remote.RequestWrapper
import com.example.data_remote.RequestWrapperImpl
import com.example.data_remote.WebServiceFactory
import com.example.data_remote.datasource.AddressDataRemoteDateSourceImpl
import com.example.data_remote.services.ViaCepService
import org.koin.dsl.bind
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        WebServiceFactory.provideOkHttpClient()
    }

    single { RequestWrapperImpl() } bind RequestWrapper::class

    single {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = "https://viacep.com.br/ws/",
        ) as ViaCepService
    }

    single<AddressDataRemoteDataSource> { AddressDataRemoteDateSourceImpl(get()) }
}