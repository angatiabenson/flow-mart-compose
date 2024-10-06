package ke.co.banit.flowmart.core

import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */

data class ApiErrorResponse(
    val code: Int,
    val status: String,
    val message: String
)

object NetworkErrorHandler {

    // Function to handle API error parsing for non-2xx responses
    fun <T> handleApiError(response: Response<T>): String {
        return try {
            val errorBody = response.errorBody()?.string()
            val errorResponse = errorBody?.let {
                Gson().fromJson(it, ApiErrorResponse::class.java)
            }
            errorResponse?.message ?: "Unknown API error (Code: ${response.code()})"
        } catch (e: Exception) {
            "An error occurred while parsing error response."
        }
    }

    // Function to handle general exceptions including HttpException and IOException
    fun handleException(exception: Exception): String {
        return when (exception) {
            is HttpException -> {
                val errorBody = exception.response()?.errorBody()?.string()
                val errorResponse = errorBody?.let {
                    Gson().fromJson(it, ApiErrorResponse::class.java)
                }
                errorResponse?.message ?: "HTTP Error ${exception.code()}: ${exception.message()}"
            }

            is IOException -> {
                "Network error, please check your internet connection."
            }

            else -> {
                "Unexpected error, ${exception.message}"
            }
        }
    }
}