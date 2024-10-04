package ke.co.banit.flowmart.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ke.co.banit.flowmart.data.model.Product
import ke.co.banit.flowmart.data.model.SummaryData
import ke.co.banit.flowmart.presentation.components.CategoryCreationBottomSheet
import ke.co.banit.flowmart.presentation.navigation.Screen
import ke.co.banit.flowmart.presentation.screens.home.components.GreetingSection
import ke.co.banit.flowmart.presentation.screens.home.components.QuickActionsSection
import ke.co.banit.flowmart.presentation.screens.home.components.RecentProductsSection
import ke.co.banit.flowmart.presentation.screens.home.components.SummaryCard
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun HomeScreen(navController: NavController) {
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = Dimensions.defaultSpace,
                end = Dimensions.defaultSpace,
                start = Dimensions.defaultSpace
            )
    ) {
        GreetingSection("Angatia Benson")
        Spacer(modifier = Modifier.height(Dimensions.lg))
        SummaryCard(SummaryData("Fruits", 10, 5))
        Spacer(modifier = Modifier.height(Dimensions.lg))
        QuickActionsSection(onAddProduct = {
            navController.navigate(Screen.CreateProduct.route)
        }, onAddCategory = {
            showBottomSheet = true
        }, onViewAllProducts = {
            navController.navigate(Screen.ViewProducts.route)
        })
        Spacer(modifier = Modifier.height(Dimensions.lg))
        RecentProductsSection(
            recentProducts =
            listOf(
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
            ),
            onViewAllRecentProducts = {
                navController.navigate(Screen.ViewProducts.route)
            },
            onEditProduct = {},
            onDeleteProduct = {}
        )

        CategoryCreationBottomSheet(
            isVisible = showBottomSheet,
            onDismiss = { showBottomSheet = false },
            onCategoryCreated = { newCategory ->
                showBottomSheet = false
            }
        )
    }
}



