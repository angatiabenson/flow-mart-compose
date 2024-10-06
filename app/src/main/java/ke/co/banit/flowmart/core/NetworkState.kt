package ke.co.banit.flowmart.core

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
sealed class NetworkState<out T> {
    data object Idle : NetworkState<Nothing>()
    data object Loading : NetworkState<Nothing>()
    data class Success<T>(val data: T, val transactionId: Long = System.currentTimeMillis()) :
        NetworkState<T>()

    data class Error(val message: String, val transactionId: Long = System.currentTimeMillis()) :
        NetworkState<Nothing>()
}