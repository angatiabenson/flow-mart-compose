package ke.co.banit.flowmart.presentation.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ke.co.banit.flowmart.data.model.Product
import ke.co.banit.flowmart.presentation.components.MScreenTitle
import ke.co.banit.flowmart.presentation.components.MTopAppBar
import ke.co.banit.flowmart.presentation.components.ProductCard
import ke.co.banit.flowmart.presentation.screens.product.components.MSearchBar
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/30/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun ViewProductsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            MTopAppBar(
                title = { MScreenTitle(title = "View Products") },
                showBackButton = true,
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = Dimensions.defaultSpace)
        ) {
            MSearchBar()
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
            ProductList(
                products =
                listOf(
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                    Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                ),
                onEditProduct = {},
                onDeleteProduct = {}
            )
        }
    }
}

@Composable
fun ProductList(
    modifier: Modifier = Modifier, products: List<Product>, onEditProduct: (Product) -> Unit,
    onDeleteProduct: (Product) -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = rememberLazyListState()
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onEdit = { onEditProduct(product) },
                onDelete = { onDeleteProduct(product) }
            )
        }
    }
}