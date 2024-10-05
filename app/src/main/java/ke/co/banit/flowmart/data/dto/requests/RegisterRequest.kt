package ke.co.banit.flowmart.data.dto.requests

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
data class RegisterRequest(
    val email: String,
    val name: String,
    val password: String,
    val phone: String
)