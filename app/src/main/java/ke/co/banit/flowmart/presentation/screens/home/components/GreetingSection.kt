package ke.co.banit.flowmart.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.User
import ke.co.banit.flowmart.presentation.theme.Dimensions

/**
 * @Author: Angatia Benson
 * @Date: 10/4/2024
 * Copyright (c) 2024 BanIT
 */

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