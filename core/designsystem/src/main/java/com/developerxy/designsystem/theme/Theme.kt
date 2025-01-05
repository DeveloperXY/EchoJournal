package com.developerxy.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun EchoJournalTheme(
    echoJournalColorScheme: EchoJournalColorScheme = DefaultEchoJournalColorScheme,
    echoJournalTypography: EchoJournalTypography = DefaultEchoJournalTypography,
    content: @Composable () -> Unit
) {
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