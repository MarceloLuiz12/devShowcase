package com.example.data_remote

import com.example.domain.exception.GenericException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import retrofit2.Response

class RequestWrapperImpl : RequestWrapper, KoinComponent {

    override suspend fun <T> wrapperRequest(call: suspend () -> Response<T>): T {
        return wrapper(call)
    }

    private suspend fun <T> wrapper(call: suspend () -> Response<T>): T {
        return try {
            call().let {
                if(it.errorBody() != null) {
                    val errorBody = it.errorBody()?.string()
                    val requestException = errorBody?.toRequestException()
                    throw determineException(requestException)
                }else {
                    it.body() ?: throw Exception(ERROR_EXCEPTION)
                }
            }
        } catch (httpException: HttpException){
            val errorBody = httpException.response()?.errorBody()?.string()
            val requestException = errorBody?.toRequestException()
            throw determineException(requestException)

        } catch (e: Exception) {
            throw e
        }
    }

    private fun determineException(requestException: RequestException?) : Exception {
        return  GenericException(requestException?.error, requestException?.errorDescription)
    }

    private fun String.toRequestException(): RequestException? = try {
        Gson().getAdapter(TypeToken.get(RequestException::class.java)).fromJson(this)
    } catch (e: Exception) {
        null
    }

    companion object {
        private const val ERROR_EXCEPTION = "Erro ao realizar requisição"
    }
}