package ke.co.banit.flowmart.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.R

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun ThemedAppLogo(modifier: Modifier = Modifier, size:Dp = 120.dp) {
    // Detect if the system is in dark theme
    val isDarkTheme = isSystemInDarkTheme()

    // Choose the tint color based on the theme
    val tintColor = if (isDarkTheme) Color.White else Color.Black

    Image(
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = "App Logo",
        modifier = modifier.size(size),
        colorFilter = ColorFilter.tint(tintColor)
    )
}