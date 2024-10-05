package ke.co.banit.flowmart.data.repository

import jakarta.inject.Inject
import ke.co.banit.flowmart.core.NetworkErrorHandler
import ke.co.banit.flowmart.data.api.APIService
import ke.co.banit.flowmart.data.dto.requests.LoginRequest
import ke.co.banit.flowmart.data.dto.requests.RegisterRequest
import ke.co.banit.flowmart.data.dto.response.AuthResponse
import ke.co.banit.flowmart.domain.repository.AuthRepository

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
class AuthRepositoryImpl @Inject constructor(private val apiService: APIService) : AuthRepository {
    override suspend fun login(body: LoginRequest): Result<AuthResponse> {
        return try {
            val response = apiService.login(body)

            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                val errorMessage = NetworkErrorHandler.handleApiError(response)
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            val errorMessage = NetworkErrorHandler.handleException(e)
            Result.failure(Exception(errorMessage))
        }
    }

    override suspend fun register(body: RegisterRequest): Result<AuthResponse> {
        return try {
            val response = apiService.register(body)

            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                val errorMessage = NetworkErrorHandler.handleApiError(response)
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            val errorMessage = NetworkErrorHandler.handleException(e)
            Result.failure(Exception(errorMessage))
        }
    }
}