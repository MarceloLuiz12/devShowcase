package com.example.data_remote

import retrofit2.Response

interface RequestWrapper {
    suspend fun <T> wrapperRequest(call: suspend () -> Response<T>): T
}