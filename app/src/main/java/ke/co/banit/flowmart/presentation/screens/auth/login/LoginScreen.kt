package ke.co.banit.flowmart.presentation.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ke.co.banit.flowmart.core.NetworkState
import ke.co.banit.flowmart.presentation.components.LoadingDialog
import ke.co.banit.flowmart.presentation.components.MSnackbarHost
import ke.co.banit.flowmart.presentation.components.ThemedAppLogo
import ke.co.banit.flowmart.presentation.navigation.Screen
import ke.co.banit.flowmart.presentation.screens.auth.login.components.LoginForm
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController
) {
    // State variables
    val loginState by viewModel.loginState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Derived state
    val isLoading = loginState is NetworkState.Loading

    // Handle side effects
    LaunchedEffect(loginState) {
        if (loginState is NetworkState.Success) {
            navController.navigate(Screen.Main.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.errorEvent.collect { errorMessage ->
            snackbarHostState.showSnackbar(
                message = errorMessage,
                duration = SnackbarDuration.Short
            )
        }
    }

    // UI Content
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { MSnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(Dimensions.defaultSpace)
        ) {
            // App Logo
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                ThemedAppLogo()
            }

            // Login Form
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoginForm(
                    email = email,
                    onEmailChange = { email = it },
                    password = password,
                    onPasswordChange = { password = it },
                    onLoginClick = { viewModel.login(email, password) },
                    onSignUpClick = { navController.navigate(Screen.SignUp.route) }
                )
                Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            }
        }

        // Loading Indicator
        LoadingDialog(isLoading = isLoading)
    }
}