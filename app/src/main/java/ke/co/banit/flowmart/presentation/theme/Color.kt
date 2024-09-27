package ke.co.banit.flowmart.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme

// Base colors
val Primary = Color(0xFFFFA300)
val Secondary = Color(0xFF005CFF)

// Light Mode Colors
val LightPrimaryContainer = Color(0xFFFFE0B2)          // Light Orange
val LightOnPrimaryContainer = Color(0xFF3E2723)       // Dark Brown

val LightSecondaryContainer = Color(0xFFB3E5FC)        // Light Blue
val LightOnSecondaryContainer = Color(0xFF002B6F)     // Dark Blue

val LightTertiary = Color(0xFF388E3C)                  // Medium Green
val LightOnTertiary = Color(0xFFFFFFFF)               // White

val LightTertiaryContainer = Color(0xFFA5D6A7)         // Light Green
val LightOnTertiaryContainer = Color(0xFF1B5E20)      // Dark Green

val LightBackground = Color(0xFFFFFBFF)               // Off-White
val LightOnBackground = Color(0xFF1F1B16)             // Dark Brown

val LightSurface = Color(0xFFFFFBFF)                   // Off-White
val LightOnSurface = Color(0xFF1F1B16)                 // Dark Brown

val LightSurfaceVariant = Color(0xFFE0E0E0)            // Light Gray
val LightOnSurfaceVariant = Color(0xFF424242)         // Dark Gray

val LightOutline = Color(0xFF9E9E9E)                   // Medium Gray

val LightError = Color(0xFFBA1A1A)                     // Dark Red
val LightOnError = Color(0xFFFFFFFF)                   // White

val LightErrorContainer = Color(0xFFFFDAD6)            // Light Red
val LightOnErrorContainer = Color(0xFF410002)         // Dark Red


// Dark Mode Colors
val DarkPrimary = Color(0xFFFFB74D)                    // Light Orange
val DarkOnPrimary = Color(0xFF452700)                  // Dark Brown

val DarkPrimaryContainer = Color(0xFFBF360C)            // Burnt Orange
val DarkOnPrimaryContainer = Color(0xFFFFF3E0)         // Light Cream

val DarkSecondary = Color(0xFF81D4FA)                  // Light Blue
val DarkOnSecondary = Color(0xFF003C73)                // Dark Blue

val DarkSecondaryContainer = Color(0xFF004A8C)          // Medium Blue
val DarkOnSecondaryContainer = Color(0xFFD1E9FF)       // Light Blue

val DarkTertiary = Color(0xFF66BB6A)                   // Light Green
val DarkOnTertiary = Color(0xFF003E00)                // Dark Green

val DarkTertiaryContainer = Color(0xFF2E7D32)          // Dark Green
val DarkOnTertiaryContainer = Color(0xFFD0F8CE)        // Light Green

val DarkBackground = Color(0xFF1F1B16)                 // Dark Brown
val DarkOnBackground = Color(0xFFEAE1D9)               // Light Cream

val DarkSurface = Color(0xFF1F1B16)                     // Dark Brown
val DarkOnSurface = Color(0xFFEAE1D9)                   // Light Cream

val DarkSurfaceVariant = Color(0xFF616161)              // Medium Gray
val DarkOnSurfaceVariant = Color(0xFFBDBDBD)           // Light Gray

val DarkOutline = Color(0xFFBDBDBD)                     // Light Gray

val DarkError = Color(0xFFFF8A80)                       // Light Red
val DarkOnError = Color(0xFF690005)                     // Dark Red

val DarkErrorContainer = Color(0xFF93000A)              // Dark Red
val DarkOnErrorContainer = Color(0xFFFFDAD6)           // Light Red


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