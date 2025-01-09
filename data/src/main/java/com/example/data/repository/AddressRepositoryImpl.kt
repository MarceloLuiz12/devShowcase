package com.example.data.repository

import com.example.data.remote.AddressDataRemoteDataSource
import com.example.domain.model.AddressModel
import com.example.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow

class AddressRepositoryImpl(
    private val addressDataRemoteDataSource: AddressDataRemoteDataSource
): AddressRepository {
    override fun getAddress(cep: String): Flow<AddressModel> {
        return addressDataRemoteDataSource.getAddress(cep)
    }
}