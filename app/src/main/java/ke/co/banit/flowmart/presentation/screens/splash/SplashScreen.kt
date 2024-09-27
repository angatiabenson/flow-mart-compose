package ke.co.banit.flowmart.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ke.co.banit.flowmart.R
import ke.co.banit.flowmart.presentation.theme.Dimensions
import java.time.Year
import java.util.Calendar

/**
 * @Author: Angatia Benson
 * @Date: 9/27/2024
 * Copyright (c) 2024 BanIT
 */
@Composable
fun SplashScreen() {
    val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = Dimensions.paddingLg),
        ) {
            ThemedAppLogo(modifier = Modifier.align(Alignment.Center))
            Text(
                text = "Flow Mart © $currentYear",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun ThemedAppLogo(modifier: Modifier = Modifier) {
    // Detect if the system is in dark theme
    val isDarkTheme = isSystemInDarkTheme()

    // Choose the tint color based on the theme
    val tintColor = if (isDarkTheme) Color.White else Color.Black

    Image(
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = "App Logo",
        modifier = modifier.size(120.dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}
