package ke.co.banit.flowmart.presentation.screens.product.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.presentation.components.MOutlinedTextField

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */


@OptIn(ExperimentalMaterial3Api::class) // Ensure you're using Material3 if needed
@Composable
fun CategoryDropdown(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    label: String = "Select Category",
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    // Ensure the selected category is part of the categories list
    var currentSelection by remember { mutableStateOf(selectedCategory) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        MOutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .menuAnchor(MenuAnchorType.PrimaryNotEditable),
            value = currentSelection,
            readOnly = true,
            onValueChange = { },
            label = label,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            categories.forEach { category ->
                DropdownMenuItem(
                    text = { Text(text = category, style = MaterialTheme.typography.bodyMedium) },
                    onClick = {
                        currentSelection = category
                        onCategorySelected(category)
                        expanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}