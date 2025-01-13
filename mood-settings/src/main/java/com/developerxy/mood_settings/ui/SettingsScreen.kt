package com.developerxy.mood_settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.developerxy.designsystem.component.BackEnabledAppBar
import com.developerxy.designsystem.component.EchoJournalCard
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography
import com.developerxy.mood_settings.DefaultMoodState
import com.developerxy.mood_settings.MoodEntry
import com.developerxy.mood_settings.SettingsUiState
import com.developerxy.mood_settings.SettingsViewModel
import com.developerxy.mood_settings.TopicsState
import com.developerxy.mood_settings.ui.component.ChipFlowRow
import com.developerxy.mood_settings.ui.component.MoodToggles
import com.developerxy.mood_settings.ui.component.MyTopicsCardDropdown

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    val viewModel: SettingsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SettingsScreenContent(
        onBack = onBack,
        uiState = uiState,
        onMoodToggled = viewModel::toggleMood,
        onAddDefaultTopic = viewModel::addDefaultTopic,
        onRemoveDefaultTopic = viewModel::removeDefaultTopic,
        onSetAsDefaultAndSaveTopic = viewModel::setAsDefaultAndSaveTopic,
    )
}

@Composable
private fun SettingsScreenContent(
    uiState: SettingsUiState = SettingsUiState(),
    onBack: () -> Unit = {},
    onMoodToggled: (MoodEntry) -> Unit = {},
    onRemoveDefaultTopic: (String) -> Unit = {},
    onAddDefaultTopic: (String) -> Unit = {},
    onSetAsDefaultAndSaveTopic: (String) -> Unit = {},
) {
    Scaffold(
        topBar = {
            BackEnabledAppBar(
                title = "Settings",
                onBackPressed = onBack
            )
        }
    ) { padding ->
        Column(
            Modifier
                .background(
                    brush = Brush.verticalGradient(
                        0.0f to colorsScheme().bgGradientStart.copy(alpha = 0.4f),
                        1f to colorsScheme().bgGradientEnd.copy(alpha = 0.4f),
                    )
                )
                .fillMaxSize()
                .padding(padding)
        ) {
            MyMoodCard(
                defaultMoodState = uiState.defaultMoodState,
                onMoodToggled = onMoodToggled
            )
            Spacer(Modifier.height(16.dp))
            MyTopicsCard(
                topicsState = uiState.topicsState,
                onDeleteTopic = onRemoveDefaultTopic,
                onAddDefaultTopic = onAddDefaultTopic,
                onSetAsDefaultAndSaveTopic = onSetAsDefaultAndSaveTopic,
            )
        }
    }
}

@Composable
private fun MyMoodCard(
    defaultMoodState: DefaultMoodState,
    onMoodToggled: (mood: MoodEntry) -> Unit = {}
) {
    EchoJournalCard(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "My Mood",
                style = typography().headlineSmall,
                color = colorsScheme().onSurface
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Select default mood to apply to all new entries",
                style = typography().bodyMedium,
                color = colorsScheme().onSurfaceVariant.copy(alpha = 0.6f)
            )
            Spacer(Modifier.height(14.dp))
            MoodToggles(
                moodEntries = defaultMoodState.entries,
                onMoodToggled = onMoodToggled
            )
        }
    }
}

@Composable
fun MyTopicsCard(
    modifier: Modifier = Modifier,
    topicsState: TopicsState,
    onDeleteTopic: (String) -> Unit = {},
    onAddDefaultTopic: (String) -> Unit = {},
    onSetAsDefaultAndSaveTopic: (String) -> Unit = {},
) {
    val selectedTopics = topicsState.defaultTopics
    val savedTopics = topicsState.savedTopics
    var isAddingTopic by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    Column(modifier = modifier.fillMaxWidth()) {

        MyTopicsCardContent(
            selectedTopics = selectedTopics,
            onDeleteTopic = onDeleteTopic,
            isAddingTopic = isAddingTopic,
            enterAddTopicMode = { isAddingTopic = true },
            exitAddTopicMode = { isAddingTopic = false },
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            keyboardController = keyboardController,
            focusRequester = focusRequester,
        )

        if (searchQuery.isEmpty()) return

        MyTopicsCardDropdown(
            selectedTopics = selectedTopics,
            savedTopics = savedTopics,
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            onAddDefaultTopic = onAddDefaultTopic,
            onSetAsDefaultAndSaveTopic = onSetAsDefaultAndSaveTopic,
            exitAddTopicMode = { isAddingTopic = false },
        )
    }
}

@Composable
fun MyTopicsCardContent(
    modifier: Modifier = Modifier,
    selectedTopics: Set<String>,
    onDeleteTopic: (String) -> Unit,
    isAddingTopic: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    enterAddTopicMode: () -> Unit,
    exitAddTopicMode: () -> Unit,
    keyboardController: SoftwareKeyboardController?,
    focusRequester: FocusRequester,
) {
    EchoJournalCard(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                start = 14.dp,
                end = 14.dp,
                top = 12.dp,
                bottom = 2.dp
            )
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "My Topics",
                style = typography().headlineSmall,
                color = colorsScheme().onSurface
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Select default topics to apply to all new entries",
                style = typography().bodyMedium,
                color = colorsScheme().onSurfaceVariant.copy(alpha = 0.6f)
            )
            Spacer(Modifier.height(8.dp))
            ChipFlowRow(
                selectedTopics = selectedTopics,
                onDeleteTopic = onDeleteTopic,
                isInAddTopicMode = isAddingTopic,
                searchQuery = searchQuery,
                onSearchQueryChange = onSearchQueryChange,
                enterAddTopicMode = enterAddTopicMode,
                exitAddTopicMode = exitAddTopicMode,
                keyboardController = keyboardController,
                focusRequester = focusRequester,
            )
        }
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    EchoJournalTheme {
        SettingsScreenContent()
    }
}