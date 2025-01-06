package com.developerxy.mood_entries_list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.developerxy.mood_entries_list.ui.MoodEntriesListScreen
import kotlinx.serialization.Serializable

@Serializable
data object EntriesListDestination

fun NavGraphBuilder.entriesListScreen() {
    composable<EntriesListDestination> {
        MoodEntriesListScreen()
    }
}

