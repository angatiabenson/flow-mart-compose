package ke.co.banit.flowmart.presentation.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ke.co.banit.flowmart.core.SessionManager
import ke.co.banit.flowmart.presentation.components.ThemedAppLogo
import ke.co.banit.flowmart.presentation.navigation.Screen
import ke.co.banit.flowmart.presentation.theme.Dimensions
import kotlinx.coroutines.delay
import java.util.Calendar

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)

    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    val user by viewModel.user.collectAsState()

    // Update SessionManager with API key
    LaunchedEffect(user.apiKey) {
        if (user.apiKey.isNotEmpty()) {
            SessionManager.apiKey = user.apiKey
        }
    }

    LaunchedEffect(isLoggedIn) {
        delay(2000) // Optional delay
        if (isLoggedIn && user.apiKey.isNotEmpty()) {
            navController.navigate(Screen.Main.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        } else {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceContainerLowest,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimensions.lg),
        ) {
            ThemedAppLogo(modifier = Modifier.align(Alignment.Center))
            Text(
                text = "Flow Mart © $currentYear",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


