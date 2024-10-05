package ke.co.banit.flowmart.domain.models

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
data class User(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val apiKey: String
)