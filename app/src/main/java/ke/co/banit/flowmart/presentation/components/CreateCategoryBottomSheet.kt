package ke.co.banit.flowmart.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
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
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.FolderPlus
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCreationBottomSheet(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    onCategoryCreated: (String) -> Unit
) {
    var categoryName by remember { mutableStateOf("") }

    if (isVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                onDismiss()
                categoryName = ""
            },
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.md),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Create New Category",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = Dimensions.md)
                )
                Spacer(modifier = Modifier.height(Dimensions.sm))
                Text(
                    "Organize your content efficiently by creating a new category. Please enter a unique name for the category below.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(bottom = Dimensions.md)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(Dimensions.sm))
                MOutlinedTextField(
                    value = categoryName,
                    onValueChange = { categoryName = it },
                    label = "Category Name",
                    keyboardType = KeyboardType.Text,
                    prefixIcon = {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.FolderPlus,
                            contentDescription = "Username Icon",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(Dimensions.iconMd)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(Dimensions.spaceBetweenSections))
                MButton(
                    onClick = {
                        if (categoryName.isNotBlank()) {
                            onCategoryCreated(categoryName)
                            categoryName = ""
                            onDismiss()
                        }
                    },
                    text = "Create Category",
                    enabled = categoryName.isNotEmpty()
                )
            }
        }
    }
}


