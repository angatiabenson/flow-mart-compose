package ke.co.banit.flowmart.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.banit.flowmart.presentation.navigation.Screen
import ke.co.banit.flowmart.presentation.screens.categories.CategoriesScreen
import ke.co.banit.flowmart.presentation.screens.home.HomeScreen
import ke.co.banit.flowmart.presentation.screens.main.components.MBottomAppBar
import ke.co.banit.flowmart.presentation.screens.profile.ProfileScreen

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun MainScreen(navController: NavHostController) {
    val mainNavController = rememberNavController()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        bottomBar = {
            MBottomAppBar(navController = mainNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = mainNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen(navController = navController) }
            composable(Screen.Categories.route) { CategoriesScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}