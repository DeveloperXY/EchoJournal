package com.developerxy.designsystem.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class EchoJournalColorScheme(
    val surface: Color,
    val surfaceVariant: Color,
    val inverseOnSurface: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val outline: Color,
    val outlineVariant: Color,

    val primary: Color,
    val primaryContainer: Color,
    val onPrimary: Color,
    val onPrimaryFixed: Color,
    val inversePrimary: Color,
    val secondary: Color,
    val secondaryContainer: Color,

    val surfaceTint12: Color,
    val surfaceTint15: Color,
    val background: Color,
    val onErrorContainer: Color,
    val errorContainer: Color,
    val onError: Color,

    val bgGradientStart: Color,
    val bgGradientEnd: Color,
    val btnGradientStart: Color,
    val btnGradientEnd: Color,
    val btnPressedGradientEnd: Color,
) {
    fun toColorScheme() = lightColorScheme(
        primary = primary,
        primaryContainer = primaryContainer,
        onPrimary = onPrimary,
        inversePrimary = inversePrimary,
        secondary = secondary,
        surface = surface,
        surfaceVariant = surfaceVariant,
        inverseOnSurface = inverseOnSurface,
        onSurface = onSurface,
        onSurfaceVariant = onSurfaceVariant,
        outline = outline,
        outlineVariant = outlineVariant,
        background = background,
        onErrorContainer = onErrorContainer,
        errorContainer = errorContainer,
        onError = onError
    )
}

val DefaultEchoJournalColorScheme = EchoJournalColorScheme(
    surface = Primary100,
    surfaceVariant = Color(0xFFE1E2EC),
    inverseOnSurface = Secondary95,
    onSurface = NeutralVariant10,
    onSurfaceVariant = NeutralVariant30,
    outline = NeutralVariant50,
    outlineVariant = NeutralVariant80,

    primary = Primary30,
    primaryContainer = Primary50,
    onPrimary = Primary100,
    onPrimaryFixed = Primary10,
    inversePrimary = Secondary80,
    secondary = Secondary30,
    secondaryContainer = Secondary50,

    surfaceTint12 = Color(0xFFE8EBF1),
    surfaceTint15 = Color(0xFFF6F7F9),
    background = NeutralVariant99,
    onErrorContainer = Error20,
    errorContainer = Error95,
    onError = Error100,

    bgGradientStart = Secondary90,
    bgGradientEnd = Secondary95,
    btnGradientStart = Primary60,
    btnGradientEnd = Primary50,
    btnPressedGradientEnd = Primary40,
)