@file:OptIn(ExperimentalMaterial3Api::class)

package com.developerxy.mood_record_audio.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.developerxy.designsystem.component.CancelRecordingBtn
import com.developerxy.designsystem.component.EchoJournalRecordingFloatingActionButton
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.icons.Pause
import com.developerxy.designsystem.icons.Play
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography
import com.developerxy.mood_record_audio.ui.component.PlayButton
import kotlinx.coroutines.launch

private const val recordAudioPermission = Manifest.permission.RECORD_AUDIO

@Composable
fun RecordMoodEntryBottomSheet(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    onDismissRequest: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val viewModel: RecordMoodEntryViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var showPermissionRationaleDialog by remember { mutableStateOf(false) }
    var showOpenSettingsDialog by remember { mutableStateOf(false) }
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                viewModel.startRecording(context)
            } else {
                scope.launch {
                    scaffoldState.bottomSheetState.partialExpand()
                }

                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        context as Activity,
                        recordAudioPermission
                    )
                ) {
                    showPermissionRationaleDialog = true
                } else {
                    showOpenSettingsDialog = true
                }
            }
        }

    LaunchedEffect(scaffoldState.bottomSheetState) {
        snapshotFlow { scaffoldState.bottomSheetState.currentValue }
            .collect {
                if (it == SheetValue.Expanded) {
                    when {
                        ContextCompat.checkSelfPermission(
                            context,
                            recordAudioPermission
                        ) == PackageManager.PERMISSION_GRANTED -> {
                            viewModel.startRecording(context)
                        }

                        ActivityCompat.shouldShowRequestPermissionRationale(
                            context as Activity,
                            recordAudioPermission
                        ) -> {
                            showPermissionRationaleDialog = true
                        }

                        else -> requestPermissionLauncher.launch(recordAudioPermission)
                    }
                }
            }
    }

    RecordMoodEntryBottomSheetContent(
        modifier = modifier,
        scaffoldState = scaffoldState,
        recordingState = uiState.recordingState,
        recordingDuration = uiState.recordingState.duration.formatted(),
        showPermissionRationaleDialog = showPermissionRationaleDialog,
        showOpenSettingsDialog = showOpenSettingsDialog,
        onPauseRecording = viewModel::pauseRecording,
        onResumeRecording = viewModel::resumeRecording,
        onCancelRecording = viewModel::cancelRecording,
        onDoneRecording = viewModel::finishRecording,
        onConfirmRationaleBtnClick = {
            showPermissionRationaleDialog = false
            requestPermissionLauncher.launch(recordAudioPermission)
        },
        onDismissRationaleDialog = {
            showPermissionRationaleDialog = false
            onDismissRequest()
        },
        onGoToSettings = {
            showOpenSettingsDialog = false
            context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts("package", context.packageName, null)
            })
        },
        onDismissOpenSettingsDialog = {
            showOpenSettingsDialog = false
        },
        content = content
    )
}

@Composable
private fun RecordMoodEntryBottomSheetContent(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    recordingState: RecordingState = NotRecording(),
    recordingDuration: String = "00:00:00",
    showPermissionRationaleDialog: Boolean = false,
    showOpenSettingsDialog: Boolean = false,
    onPauseRecording: () -> Unit = {},
    onResumeRecording: () -> Unit = {},
    onCancelRecording: () -> Unit = {},
    onDoneRecording: () -> Unit = {},
    onConfirmRationaleBtnClick: () -> Unit = {},
    onDismissRationaleDialog: () -> Unit = {},
    onGoToSettings: () -> Unit = {},
    onDismissOpenSettingsDialog: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetSwipeEnabled = false,
        sheetContainerColor = colorsScheme().background,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = recordingState.textDescription(),
                    style = typography().headlineMedium,
                    color = colorsScheme().onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = recordingDuration,
                    style = typography().bodySmall,
                    color = colorsScheme().onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CancelRecordingBtn(onClick = onCancelRecording)
                    EchoJournalRecordingFloatingActionButton(onClick = onDoneRecording)
                    PlayButton(
                        onClick = {
                            when(recordingState) {
                                is Paused -> onResumeRecording()
                                else -> onPauseRecording()
                            }
                        },
                        imageVector = when(recordingState) {
                            is Recording -> EchoJournalIcons.Pause
                            else -> EchoJournalIcons.Play
                        }
                    )
                }
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
            }
        },
    ) {
        content()
    }

    if (showPermissionRationaleDialog) {
        RecordAudioPermissionRationaleDialog(
            onConfirm = onConfirmRationaleBtnClick,
            onDismiss = onDismissRationaleDialog
        )
    }

    if (showOpenSettingsDialog) {
        OpenSettingsDialog(
            onGoToSettings = onGoToSettings,
            onDismiss = onDismissOpenSettingsDialog
        )
    }
}

private fun RecordingState.textDescription(): String {
    return when(this) {
        is Recording -> "Recording your memories..."
        is Paused -> "Recording paused"
        else -> ""
    }
}

@Composable
private fun RecordAudioPermissionRationaleDialog(
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
    AlertDialog(
        title = {
            Text(text = "Permission required")
        },
        text = {
            Text(text = "We need your permission to record audio so that we can capture your audio mood entries.")
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("I understand")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("No thanks")
            }
        }
    )
}

@Composable
private fun OpenSettingsDialog(
    onDismiss: () -> Unit = {},
    onGoToSettings: () -> Unit = {}
) {
    AlertDialog(
        title = {
            Text(text = "Permission permanently denied")
        },
        text = {
            Text(
                text = "You have permanently denied the app the permission to record your ideas and thoughts, " +
                        "for you to be able to record your memories back again, you will need to grant the app" +
                        " the permission to do so via system settings."
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onGoToSettings) {
                Text("Go to settings")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("No thanks")
            }
        }
    )
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