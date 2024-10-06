package ke.co.banit.flowmart.presentation.screens.main.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Home
import compose.icons.fontawesomeicons.solid.Shapes
import compose.icons.fontawesomeicons.solid.User
import ke.co.banit.flowmart.presentation.navigation.Screen

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun MBottomAppBar(modifier: Modifier = Modifier, navController: NavController) {
    val items = listOf(Screen.Home, Screen.Categories, Screen.Profile)
    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar(
        modifier = modifier.height(80.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = {
                    when (screen) {
                        Screen.Home -> Icon(
                            FontAwesomeIcons.Solid.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(20.dp)
                        )

                        Screen.Categories -> Icon(
                            FontAwesomeIcons.Solid.Shapes,
                            contentDescription = "Categories",
                            modifier = Modifier.size(20.dp)
                        )

                        else -> Icon(
                            FontAwesomeIcons.Solid.User,
                            contentDescription = "Profile",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                label = {
                    Text(
                        screen.route.replaceFirstChar(Char::titlecase),
                        style = MaterialTheme.typography.labelMedium,
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}