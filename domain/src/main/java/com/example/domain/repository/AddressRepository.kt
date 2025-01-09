package com.example.domain.repository

import com.example.domain.model.AddressModel
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    fun getAddress(cep: String): Flow<AddressModel>
}