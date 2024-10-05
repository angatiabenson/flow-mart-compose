package ke.co.banit.flowmart.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ke.co.banit.flowmart.data.mapper.Product
import ke.co.banit.flowmart.presentation.components.ProductCard

/**
 * @Author: Angatia Benson
 * @Date: 10/4/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun RecentProductsSection(
    recentProducts: List<Product>,
    onViewAllRecentProducts: () -> Unit,
    onEditProduct: (Product) -> Unit,
    onDeleteProduct: (Product) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recently Added Products",
                style = MaterialTheme.typography.titleMedium
            )
            TextButton(onClick = onViewAllRecentProducts) {
                Text("View All")
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = rememberLazyListState()
        ) {
            items(recentProducts) { product ->
                ProductCard(
                    product = product,
                    onEdit = { onEditProduct(product) },
                    onDelete = { onDeleteProduct(product) }
                )
            }
        }
    }
}