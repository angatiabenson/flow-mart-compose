package ke.co.banit.flowmart.presentation.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.co.banit.flowmart.core.NetworkState
import ke.co.banit.flowmart.data.dto.response.AuthResponse
import ke.co.banit.flowmart.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Angatia Benson
 * @Date: 10/5/2024
 * Copyright (c) 2024 BanIT
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow<NetworkState<AuthResponse>>(NetworkState.Idle)
    val loginState: StateFlow<NetworkState<AuthResponse>> = _loginState.asStateFlow()

    private val _errorEvent = MutableSharedFlow<String>()
    val errorEvent: SharedFlow<String> = _errorEvent.asSharedFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = NetworkState.Loading
            val result = loginUseCase(email, password)
            if (result.isSuccess) {
                _loginState.value = NetworkState.Success(result.getOrThrow())
            } else {
                _loginState.value = NetworkState.Idle
                _errorEvent.emit(result.exceptionOrNull()?.message ?: "Unknown error")
            }
        }
    }

}