@file:OptIn(ExperimentalMaterial3Api::class)

package com.developerxy.mood_record_audio.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.component.CancelRecordingBtn
import com.developerxy.designsystem.component.EchoJournalRecordingFloatingActionButton
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography
import com.developerxy.mood_record_audio.ui.component.PlayButton

@Composable
fun RecordMoodEntryBottomSheet(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    content: @Composable () -> Unit = {}
) {
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContainerColor = colorsScheme().background,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Start recording your entry",
                    style = typography().headlineMedium,
                    color = colorsScheme().onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "01:30:45",
                    style = typography().bodySmall,
                    color = colorsScheme().onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CancelRecordingBtn()
                    EchoJournalRecordingFloatingActionButton()
                    PlayButton()
                }
                Spacer(modifier = Modifier.safeDrawingPadding())
            }
        },
    ) {
        content()
    }
}

@Preview
@Composable
private fun RecordMoodEntryBottomSheetPreview(modifier: Modifier = Modifier) {
    val bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.Expanded)
    val state = rememberBottomSheetScaffoldState(bottomSheetState)

    EchoJournalTheme {
        RecordMoodEntryBottomSheet(scaffoldState = state)
    }
}