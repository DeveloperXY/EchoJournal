package com.developerxy.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun EchoJournalTheme(
    echoJournalColorScheme: EchoJournalColorScheme = DefaultEchoJournalColorScheme,
    echoJournalTypography: EchoJournalTypography = DefaultEchoJournalTypography,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = true
    }

    CompositionLocalProvider(
        LocalEchoJournalColors provides echoJournalColorScheme,
        LocalEchoJournalTypography provides echoJournalTypography
    ) {
        MaterialTheme(
            colorScheme = echoJournalColorScheme.toColorScheme(),
            typography = echoJournalTypography.toTypography(),
            content = content
        )
    }
}

@Composable
fun colorsScheme() = MaterialTheme.echoJournalColorScheme

@Composable
fun typography() = MaterialTheme.echoJournalTypography

val MaterialTheme.echoJournalColorScheme
    @Composable get() = LocalEchoJournalColors.current
val MaterialTheme.echoJournalTypography
    @Composable get() = LocalEchoJournalTypography.current

private val LocalEchoJournalColors = staticCompositionLocalOf { DefaultEchoJournalColorScheme }
private val LocalEchoJournalTypography = staticCompositionLocalOf { DefaultEchoJournalTypography }