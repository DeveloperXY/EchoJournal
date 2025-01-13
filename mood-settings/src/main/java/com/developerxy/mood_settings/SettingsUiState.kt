package com.developerxy.mood_settings

import androidx.compose.ui.graphics.vector.ImageVector
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.icons.ExcitedOff
import com.developerxy.designsystem.icons.ExcitedOn
import com.developerxy.designsystem.icons.NeutralOff
import com.developerxy.designsystem.icons.NeutralOn
import com.developerxy.designsystem.icons.PeacefulOff
import com.developerxy.designsystem.icons.PeacefulOn
import com.developerxy.designsystem.icons.SadOff
import com.developerxy.designsystem.icons.SadOn
import com.developerxy.designsystem.icons.StressedOff
import com.developerxy.designsystem.icons.StressedOn
import com.developerxy.domain.model.Mood

data class SettingsUiState(
    val defaultMoodState: DefaultMoodState = DefaultMoodState(),
    val topicsState: TopicsState = TopicsState()
)

data class DefaultMoodState(
    val entries: List<MoodEntry> = defaultMoodEntries
)

data class TopicsState(
    val savedTopics: Set<String> = setOf(),
    val defaultTopics: Set<String> = setOf(),
)

data class MoodEntry(
    val text: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val isSelected: Boolean = false,
)

private val defaultMoodEntries = listOf(
    MoodEntry(
        text = Mood.STRESSED.name,
        selectedIcon = EchoJournalIcons.StressedOn,
        unselectedIcon = EchoJournalIcons.StressedOff,
    ),
    MoodEntry(
        text = Mood.SAD.name,
        selectedIcon = EchoJournalIcons.SadOn,
        unselectedIcon = EchoJournalIcons.SadOff,
    ),
    MoodEntry(
        text = Mood.NEUTRAL.name,
        selectedIcon = EchoJournalIcons.NeutralOn,
        unselectedIcon = EchoJournalIcons.NeutralOff,
    ),
    MoodEntry(
        text = Mood.PEACEFUL.name,
        selectedIcon = EchoJournalIcons.PeacefulOn,
        unselectedIcon = EchoJournalIcons.PeacefulOff,
    ),
    MoodEntry(
        text = Mood.EXCITED.name,
        selectedIcon = EchoJournalIcons.ExcitedOn,
        unselectedIcon = EchoJournalIcons.ExcitedOff,
    ),
)