package ke.co.banit.flowmart.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme

// Base colors
val Primary = Color(0xFFFFA300)
val Secondary = Color(0xFF005CFF)

// Light Mode Colors
val LightPrimaryContainer = Color(0xFFFFECCC)
val LightOnPrimaryContainer = Color(0xFF2E1D00)
val LightSecondaryContainer = Color(0xFFD8E2FF)
val LightOnSecondaryContainer = Color(0xFF001849)
val LightTertiary = Color(0xFF685E40)
val LightOnTertiary = Color(0xFFFFFFFF)
val LightTertiaryContainer = Color(0xFFF1E2BC)
val LightOnTertiaryContainer = Color(0xFF221B04)
val LightBackground = Color(0xFFFFFBFF)
val LightOnBackground = Color(0xFF1F1B16)
val LightSurface = Color(0xFFFFFBFF)
val LightOnSurface = Color(0xFF1F1B16)
val LightSurfaceVariant = Color(0xFFF0E0CF)
val LightOnSurfaceVariant = Color(0xFF4F4539)
val LightOutline = Color(0xFF817567)
val LightError = Color(0xFFBA1A1A)
val LightOnError = Color(0xFFFFFFFF)
val LightErrorContainer = Color(0xFFFFDAD6)
val LightOnErrorContainer = Color(0xFF410002)

// Dark Mode Colors
val DarkPrimary = Color(0xFFFFB945)
val DarkOnPrimary = Color(0xFF4C2E00)
val DarkPrimaryContainer = Color(0xFF6E4300)
val DarkOnPrimaryContainer = Color(0xFFFFDEB7)
val DarkSecondary = Color(0xFFAEC6FF)
val DarkOnSecondary = Color(0xFF002C75)
val DarkSecondaryContainer = Color(0xFF0040A3)
val DarkOnSecondaryContainer = Color(0xFFD8E2FF)
val DarkTertiary = Color(0xFFD5C6A1)
val DarkOnTertiary = Color(0xFF393016)
val DarkTertiaryContainer = Color(0xFF50472A)
val DarkOnTertiaryContainer = Color(0xFFF1E2BC)
val DarkBackground = Color(0xFF232323)
val DarkOnBackground = Color(0xFFEAE1D9)
val DarkSurface = Color(0xFF1F1B16)
val DarkOnSurface = Color(0xFFEAE1D9)
val DarkSurfaceVariant = Color(0xFF4F4539)
val DarkOnSurfaceVariant = Color(0xFFD3C4B4)
val DarkOutline = Color(0xFF9C8F80)
val DarkError = Color(0xFFFFB4AB)
val DarkOnError = Color(0xFF690005)
val DarkErrorContainer = Color(0xFF93000A)
val DarkOnErrorContainer = Color(0xFFFFDAD6)

val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = Secondary,
    onSecondary = Color.White,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer
)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer
)