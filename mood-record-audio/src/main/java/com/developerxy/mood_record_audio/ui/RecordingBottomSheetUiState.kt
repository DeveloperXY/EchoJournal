package com.developerxy.mood_record_audio.ui

import kotlin.time.Duration

internal data class RecordingBottomSheetUiState(
    val recordingState: RecordingState = NotRecording
)

//@Immutable
internal sealed interface RecordingState
data object NotRecording : RecordingState
data class Paused(val duration: Duration) : RecordingState
data class Recording(val duration: Duration) : RecordingState
data class DoneRecording(val duration: Duration) : RecordingState