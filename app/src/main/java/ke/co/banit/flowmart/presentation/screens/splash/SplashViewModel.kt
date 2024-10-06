package ke.co.banit.flowmart.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.co.banit.flowmart.core.DataStoreManager
import ke.co.banit.flowmart.domain.models.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * @Author: Angatia Benson
 * @Date: 10/6/2024
 * Copyright (c) 2024 BanIT
 */

@HiltViewModel
class SplashViewModel @Inject constructor(
    dataStoreManager: DataStoreManager
) : ViewModel() {

    val isLoggedIn: StateFlow<Boolean> = dataStoreManager.isLoggedIn
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)

    val user: StateFlow<User> = dataStoreManager.user
        .stateIn(viewModelScope, SharingStarted.Eagerly, User("", 0, "", "", ""))
}
