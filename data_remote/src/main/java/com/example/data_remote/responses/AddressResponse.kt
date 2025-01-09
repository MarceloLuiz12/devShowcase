package com.example.data_remote.responses

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("cep")
    val postalCode: String,
    @SerializedName("logradouro")
    val street: String,
    @SerializedName("bairro")
    val neighborhood: String,
    @SerializedName("localidade")
    val city: String,
    @SerializedName("uf")
    val state: String
)