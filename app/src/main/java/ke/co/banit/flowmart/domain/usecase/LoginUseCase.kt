package ke.co.banit.flowmart.domain.usecase

import ke.co.banit.flowmart.data.dto.requests.LoginRequest
import ke.co.banit.flowmart.data.dto.response.AuthResponse
import ke.co.banit.flowmart.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<AuthResponse> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Email or password should not be empty"))
        }
        return repository.login(LoginRequest(email = email, password = password))
    }
}
