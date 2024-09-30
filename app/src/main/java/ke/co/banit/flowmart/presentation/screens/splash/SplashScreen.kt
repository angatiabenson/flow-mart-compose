package ke.co.banit.flowmart.presentation.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
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
fun SplashScreen(navController: NavHostController) {
    val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)

    LaunchedEffect(key1 = true) {
        delay(3000) // 3 seconds delay
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
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


