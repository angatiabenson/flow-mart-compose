package ke.co.banit.flowmart.domain.repository

import ke.co.banit.flowmart.data.dto.requests.LoginRequest
import ke.co.banit.flowmart.data.dto.requests.RegisterRequest
import ke.co.banit.flowmart.data.dto.response.AuthResponse

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
interface AuthRepository {
    suspend fun login(body: LoginRequest): Result<AuthResponse>
    suspend fun register(body: RegisterRequest): Result<AuthResponse>
}