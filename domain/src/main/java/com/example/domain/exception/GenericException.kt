package com.example.domain.exception

data class GenericException(
    val error: String?,
    val errorDescription: String?
) : Exception(errorDescription)