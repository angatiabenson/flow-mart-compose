package ke.co.banit.flowmart.presentation.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.banit.flowmart.presentation.screens.login.LoginScreen
import ke.co.banit.flowmart.presentation.screens.signup.SignUpScreen
import ke.co.banit.flowmart.presentation.screens.splash.SplashScreen
import kotlinx.coroutines.delay

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen()
            LaunchedEffect(key1 = true) {
                delay(3000) // 3 seconds delay
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onSignUpClick = { navController.navigate(Screen.SignUp.route) }
            )
        }
        composable(Screen.SignUp.route) {
            SignUpScreen(
                onLoginClick = { navController.popBackStack() }
            )
        }
    }
}