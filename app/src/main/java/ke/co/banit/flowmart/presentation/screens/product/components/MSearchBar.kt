package ke.co.banit.flowmart.presentation.screens.product.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @Author: Angatia Benson
 * @Date: 10/4/2024
 * Copyright (c) 2024 BanIT
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MSearchBar(modifier: Modifier = Modifier) {
    var active by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = { active = false },
                expanded = active,
                onExpandedChange = { active = it },
                enabled = true,
                placeholder = { Text("Search", style = MaterialTheme.typography.bodyMedium) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                },
                trailingIcon = {
                    if (active)
                        Icon(
                            modifier = Modifier.clickable {
                                if (searchQuery.isNotEmpty()) {
                                    searchQuery = ""
                                } else {
                                    active = false
                                }
                            },
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null
                        )
                },
            )
        },
        expanded = active,
        onExpandedChange = { active = it },
        modifier = modifier
            .fillMaxWidth(),
        shape = SearchBarDefaults.inputFieldShape,
        tonalElevation = 0.dp,
        shadowElevation = SearchBarDefaults.ShadowElevation,
        windowInsets = SearchBarDefaults.windowInsets,
        content = {

        }
    )
}