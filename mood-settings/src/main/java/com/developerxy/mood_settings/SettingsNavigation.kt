package com.developerxy.mood_settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.developerxy.mood_settings.ui.SettingsScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingsDestination

fun NavGraphBuilder.settingsScreen(
    onBack: () -> Unit
) {
    composable<SettingsDestination> {
        SettingsScreen(onBack = onBack)
    }
}

