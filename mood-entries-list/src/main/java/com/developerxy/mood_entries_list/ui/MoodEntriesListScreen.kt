@file:OptIn(ExperimentalMaterial3Api::class)

package com.developerxy.mood_entries_list.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.component.DefaultAppBar
import com.developerxy.designsystem.component.EchoJournalFloatingActionButton
import com.developerxy.designsystem.component.EchoJournalMemoPlayer
import com.developerxy.designsystem.icons.Add
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.mood_record_audio.ui.RecordMoodEntryBottomSheet
import kotlinx.coroutines.launch

@Composable
fun MoodEntriesListScreen(
    onOpenSettings: () -> Unit
) {
    MoodEntriesListScreenContent(
        onOpenSettings = onOpenSettings
    )
}

@Composable
private fun MoodEntriesListScreenContent(
    onOpenSettings: () -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded,
            skipHiddenState = true
        )
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState)

    BackHandler(enabled = bottomSheetState.isVisible) { scope.launch { bottomSheetState.partialExpand() } }

    RecordMoodEntryBottomSheet(
        scaffoldState = scaffoldState,
        onDismissRequest = { scope.launch { bottomSheetState.partialExpand() } }
    ) {
        Scaffold(
            topBar = {
                DefaultAppBar(
                    onClickSettings = onOpenSettings
                )
            },
            floatingActionButton = {
                EchoJournalFloatingActionButton(
                    modifier = Modifier.shadow(
                        elevation = 16.dp,
                        shape = CircleShape,
                        spotColor = colorsScheme().btnGradientEnd,
                    ),
                    icon = {
                        Icon(
                            modifier = Modifier.requiredSize(24.dp),
                            imageVector = EchoJournalIcons.Add,
                            contentDescription = "Add",
                            tint = colorsScheme().onPrimary
                        )
                    },
                    onClick = {
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                )
            },
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            0.0f to colorsScheme().bgGradientStart,
                            1f to colorsScheme().bgGradientEnd,
                        )
                    )
                    .padding(padding)
            ) {
                EchoJournalMemoPlayer()
            }
        }
    }
}

@Preview
@Composable
fun MoodEntriesListScreenPreview() {
    EchoJournalTheme {
        MoodEntriesListScreenContent()
    }
}