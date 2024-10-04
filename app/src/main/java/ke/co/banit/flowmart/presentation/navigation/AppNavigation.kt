package ke.co.banit.flowmart.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.banit.flowmart.presentation.screens.auth.login.LoginScreen
import ke.co.banit.flowmart.presentation.screens.auth.signup.SignUpScreen
import ke.co.banit.flowmart.presentation.screens.main.MainScreen
import ke.co.banit.flowmart.presentation.screens.product.CreateProductScreen
import ke.co.banit.flowmart.presentation.screens.product.ViewProductsScreen
import ke.co.banit.flowmart.presentation.screens.splash.SplashScreen

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
            SplashScreen(navController = navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }

        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }

        composable(Screen.CreateProduct.route) {
            CreateProductScreen(navController = navController)
        }

        composable(Screen.ViewProducts.route) {
            ViewProductsScreen(navController = navController)
        }
    }
}