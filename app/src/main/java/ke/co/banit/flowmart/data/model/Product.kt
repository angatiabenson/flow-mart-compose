package ke.co.banit.flowmart.data.model

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
data class Product(
    val id: String,
    val name: String,
    val category: String,
    val quantity: Int,
    val imageUrl: String
)
