package com.example.domain.usecase

import com.example.domain.core.UseCase
import com.example.domain.model.AddressModel
import com.example.domain.repository.AddressRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetAddressUseCase(
    scope: CoroutineScope,
    private val repository: AddressRepository
) : UseCase<AddressModel, String>(scope = scope){
    override fun run(params: String?): Flow<AddressModel> = when(params) {
        null -> throw NullPointerException()
        else -> repository.getAddress(
            params
        )
    }
}