package ke.co.banit.flowmart.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @Author: Angatia Benson
 * @Date: 9/29/2024
 * Copyright (c) 2024 BanIT
 */

@Composable
fun MScreenTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}