package ke.co.banit.flowmart.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Box
import compose.icons.fontawesomeicons.solid.FolderPlus
import compose.icons.fontawesomeicons.solid.User
import ke.co.banit.flowmart.R
import ke.co.banit.flowmart.data.model.Product
import ke.co.banit.flowmart.data.model.SummaryData
import ke.co.banit.flowmart.presentation.components.CategoryCreationBottomSheet
import ke.co.banit.flowmart.presentation.components.MDropdownMenu
import ke.co.banit.flowmart.presentation.components.MDropdownMenuItem
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun HomeScreen() {
    var showBottomSheet by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.defaultSpace)
    ) {
        GreetingSection("Angatia Benson")
        Spacer(modifier = Modifier.height(Dimensions.lg))
        SummaryCard(SummaryData("Fruits", 10, 5))
        Spacer(modifier = Modifier.height(Dimensions.lg))
        QuickActionsSection(onAddProduct = {

        }, onAddCategory = {
            showBottomSheet = true
        }, onViewAllProducts = {})
        Spacer(modifier = Modifier.height(Dimensions.lg))
        RecentProductsSection(
            recentProducts =
            listOf(
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
                Product("1", "Laptop", "Electronics", 5, "https://example.com/laptop.jpg"),
            ),
            onViewAllRecentProducts = {},
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

@Composable
fun GreetingSection(userName: String) {
    Row {
        Icon(
            imageVector = FontAwesomeIcons.Solid.User,
            contentDescription = "User Icon",
            modifier = Modifier.size(Dimensions.iconLg)
        )
        Spacer(modifier = Modifier.width(Dimensions.md))
        Column {
            Text(text = "Welcome Back,", style = MaterialTheme.typography.bodyMedium)
            Text(text = userName, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun SummaryCard(summaryData: SummaryData) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(Dimensions.defaultSpace)) {
            Text(
                text = "Summary",
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(Dimensions.spaceBetweenItems))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SummaryItem(
                    title = "Common Category",
                    value = summaryData.commonCategory
                )
                SummaryItem(
                    title = "Products",
                    value = summaryData.productCount.toString()
                )
                SummaryItem(
                    title = "Categories",
                    value = summaryData.categoryCount.toString()
                )
            }
        }
    }
}

@Composable
fun SummaryItem(title: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(Dimensions.sm))
        Text(text = value, style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun QuickActionsSection(
    onAddCategory: () -> Unit,
    onAddProduct: () -> Unit,
    onViewAllProducts: () -> Unit
) {
    Column {
        Text(
            text = "Quick Action",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(Dimensions.spaceBetweenItems))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickActionCard(
                icon = FontAwesomeIcons.Solid.FolderPlus,
                text = "Add Category",
                onClick = onAddCategory
            )
            QuickActionCard(
                icon = FontAwesomeIcons.Solid.Box,
                text = "View Products",
                onClick = onViewAllProducts
            )
            QuickActionCard(
                icon = Icons.Default.Add,
                text = "Add Product",
                onClick = onAddProduct
            )
        }
    }
}

@Composable
fun QuickActionCard(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.width(115.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(Dimensions.md)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(Dimensions.iconMd)
            )
            Spacer(modifier = Modifier.height(Dimensions.md))
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

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

@Composable
fun ProductCard(
    product: Product,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimensions.sm)
    ) {
        Row(
            modifier = Modifier
                .padding(Dimensions.sm)
                .height(IntrinsicSize.Min)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.app_logo),
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(Dimensions.sm))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(Dimensions.xs))
                Text(
                    text = product.category,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${product.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                )
            }

            MDropdownMenu(
                items = listOf(
                    MDropdownMenuItem(
                        text = "Edit",
                        icon = Icons.Default.Edit,
                        onClick = onEdit
                    ),
                    MDropdownMenuItem(
                        text = "Delete",
                        icon = Icons.Default.Delete,
                        onClick = onDelete
                    )
                )
            )
        }
    }
}