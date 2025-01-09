package com.example.data_remote.mapper

import com.example.data_remote.responses.AddressResponse
import com.example.domain.model.AddressModel

fun AddressResponse.toDomain() = AddressModel(
    postalCode = postalCode,
    street = street,
    neighborhood = neighborhood,
    city = city,
    state = state
)