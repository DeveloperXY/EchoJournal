package com.developerxy.echojournal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.developerxy.mood_entries_list.EntriesListDestination
import com.developerxy.mood_entries_list.entriesListScreen

@Composable
fun EchoJournalNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = EntriesListDestination
    ) {
        entriesListScreen()
    }
}