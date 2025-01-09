package com.example.data_remote

import com.google.gson.annotations.SerializedName

data class RequestException(
    @SerializedName("error") val error: String?,
    @SerializedName("error_description") val errorDescription: String?
) : Exception(errorDescription)