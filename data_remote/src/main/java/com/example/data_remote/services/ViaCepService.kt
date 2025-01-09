package com.example.data_remote.services

import com.example.data_remote.responses.AddressResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun getMinVersion(
        @Path("cep") cep: String
    ): Response<AddressResponse>
}