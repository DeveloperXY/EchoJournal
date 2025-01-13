package com.developerxy.echojournal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.developerxy.mood_entries_list.EntriesListDestination
import com.developerxy.mood_entries_list.entriesListScreen
import com.developerxy.mood_settings.SettingsDestination
import com.developerxy.mood_settings.settingsScreen

@Composable
fun EchoJournalNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = EntriesListDestination
    ) {
        entriesListScreen(
            onOpenSettings = { navController.navigate(SettingsDestination)}
        )
        settingsScreen(
            onBack = { navController.popBackStack() }
        )
    }
}