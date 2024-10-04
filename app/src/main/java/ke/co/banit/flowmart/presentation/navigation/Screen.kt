package ke.co.banit.flowmart.presentation.navigation

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */
sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object SignUp : Screen("signup")
    data object Main : Screen("main")
    data object Home : Screen("home")
    data object Categories : Screen("categories")
    data object Profile : Screen("profile")
    data object CreateProduct : Screen("create-product")
    data object ViewProducts : Screen("view-product")
}