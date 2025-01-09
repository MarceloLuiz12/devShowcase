package com.example.data.remote

import com.example.domain.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface AddressDataRemoteDataSource {
    fun getAddress(cep: String): Flow<AddressModel>
}