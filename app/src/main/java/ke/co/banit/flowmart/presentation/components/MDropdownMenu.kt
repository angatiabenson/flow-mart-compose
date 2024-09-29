package ke.co.banit.flowmart.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */

data class MDropdownMenuItem(
    val text: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

@Composable
fun MDropdownMenu(
    items: List<MDropdownMenuItem>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Outlined.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item.text, style = MaterialTheme.typography.labelLarge) },
                    onClick = {
                        item.onClick()
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(item.icon, contentDescription = item.text)
                    }
                )
            }
        }
    }
}