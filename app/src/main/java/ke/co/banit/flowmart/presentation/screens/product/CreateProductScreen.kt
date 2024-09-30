package ke.co.banit.flowmart.presentation.screens.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ke.co.banit.flowmart.presentation.components.MButton
import ke.co.banit.flowmart.presentation.components.MOutlinedTextField
import ke.co.banit.flowmart.presentation.components.MScreenTitle
import ke.co.banit.flowmart.presentation.components.MTopAppBar
import ke.co.banit.flowmart.presentation.screens.product.components.CategoryDropdown
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun CreateProductScreen(navController: NavHostController) {
    val categories = listOf("Electronics", "Books", "Clothing", "Home & Kitchen", "Sports")

    var productName by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Scaffold(
        topBar = {
            MTopAppBar(
                title = { MScreenTitle(title = "Create Product") },
                showBackButton = true,
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(all = Dimensions.defaultSpace)
        ) {
            Text(
                "Add a new product by providing its details such as name, category, price, and description to expand your inventory.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = Dimensions.md)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MOutlinedTextField(
                    value = productName,
                    onValueChange = { productName = it },
                    label = "Product Name",
                    keyboardType = KeyboardType.Text,
                )
                Spacer(modifier = Modifier.height(Dimensions.spaceBetweenInputFields))
                MOutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it },
                    label = "Quantity",
                    keyboardType = KeyboardType.Text,
                )
                Spacer(modifier = Modifier.height(Dimensions.spaceBetweenInputFields))
                CategoryDropdown(
                    categories = categories,
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it },
                    label = "Product Category",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(Dimensions.lg))
            }
            MButton(
                onClick = {
                    //validate input
                    //login
                    //navigate to home screen
                },
                text = "Create Product"
            )
        }
    }
}