package ke.co.banit.flowmart.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.LayerGroup
import compose.icons.fontawesomeicons.solid.User
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
fun MainScreen() {
    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            MBottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Categories.route) { CategoriesScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}