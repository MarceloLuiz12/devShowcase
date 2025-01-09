package com.example.data_remote.datasource

import com.example.data.remote.AddressDataRemoteDataSource
import com.example.data_remote.RequestWrapper
import com.example.data_remote.mapper.toDomain
import com.example.data_remote.services.ViaCepService
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddressDataRemoteDateSourceImpl(
    private val webService: ViaCepService
): AddressDataRemoteDataSource, KoinComponent {
    private val requestWrapper: RequestWrapper by inject()
    override fun getAddress(cep: String) = flow{
        emit(
            requestWrapper.wrapperRequest{
                webService.getMinVersion(cep)
            }.toDomain()
        )
    }
}