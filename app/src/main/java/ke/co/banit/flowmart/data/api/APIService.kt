package ke.co.banit.flowmart.data.api

import ke.co.banit.flowmart.data.dto.requests.LoginRequest
import ke.co.banit.flowmart.data.dto.requests.RegisterRequest
import ke.co.banit.flowmart.data.dto.response.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
interface APIService {
    @POST("/login")
    suspend fun login(@Body body: LoginRequest): Response<AuthResponse>

    @POST("/register")
    suspend fun register(@Body body: RegisterRequest): Response<AuthResponse>
}