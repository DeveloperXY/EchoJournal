package com.developerxy.mood_record_audio.ui

import java.util.Locale
import kotlin.time.Duration

internal data class RecordingBottomSheetUiState(
    val recordingState: RecordingState = NotRecording()
)

//@Immutable
internal sealed interface RecordingState {
    val duration: RecordingDuration
}
data class NotRecording(override val duration: RecordingDuration = RecordingDuration()) : RecordingState
data class Paused(override val duration: RecordingDuration) : RecordingState
data class Recording(override val duration: RecordingDuration) : RecordingState
data class DoneRecording(override val duration: RecordingDuration) : RecordingState

data class RecordingDuration(val value: Duration = Duration.ZERO) {
    fun formatted(): String {
        val totalSeconds = value.inWholeSeconds
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)
    }
}