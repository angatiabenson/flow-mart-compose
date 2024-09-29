package ke.co.banit.flowmart.presentation.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.data.model.Category
import ke.co.banit.flowmart.presentation.components.MDropdownMenu
import ke.co.banit.flowmart.presentation.components.MDropdownMenuItem
import ke.co.banit.flowmart.presentation.components.MScreenTitle
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/28/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun CategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.defaultSpace)
    ) {
        MScreenTitle(title = "Categories")
        Spacer(modifier = Modifier.height(Dimensions.lg))
        CategoryGridSection(onCategoryClick = {})
    }
}

@Composable
fun CategoryGridSection(onCategoryClick: () -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(Dimensions.sm),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.sm),
        contentPadding = PaddingValues.Absolute(bottom = Dimensions.defaultSpace)
    ) {
        items(18) {
            CategoryCard(
                onClick = onCategoryClick,
                onEdit = {},
                onDelete = {},
                data = Category("1", "Fruits", 10)
            )
        }
    }
}

@Composable
fun CategoryCard(
    onClick: () -> Unit, onEdit: () -> Unit,
    onDelete: () -> Unit, data: Category
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.width(115.dp).height(115.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Dropdown menu in the top right corner
            MDropdownMenu(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp),
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

            // Centered content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = data.name,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "(${data.productCount})",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

