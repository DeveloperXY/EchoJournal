package com.developerxy.mood_record_audio.ui

import android.content.Context
import android.media.MediaRecorder
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
internal class RecordMoodEntryViewModel @Inject constructor() : ViewModel() {
    private var _uiState = MutableStateFlow(RecordingBottomSheetUiState())
    val uiState = _uiState.asStateFlow()

    private val mutex = Mutex()
    private val timeDurationChannel = Channel<Long>(Channel.UNLIMITED)
    private var recorder: MediaRecorder? = null
    private var senderJob: Job? = null
    private var consumerJob: Job? = null

    fun startRecording(context: Context) {
        viewModelScope.launch(Dispatchers.Default) {
            MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(context.generateFileTimestampName())
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                prepare()
                start()
                recorder = this
            }
            _uiState.update {
                it.copy(recordingState = Recording(duration = RecordingDuration()))
            }
        }.invokeOnCompletion {
            it?.let {
                // handle exception
            }
        }

        senderJob = viewModelScope.launch(Dispatchers.Default) {
            var nextSendTime = System.currentTimeMillis()
            while (isActive) {
                mutex.withLock {
                    val isRecording = _uiState.value.recordingState is Recording
                    if (isRecording) {
                        timeDurationChannel.send(100)
                        nextSendTime += 100
                        val delayTime = nextSendTime - System.currentTimeMillis()
                        if (delayTime > 0) {
                            delay(delayTime)
                        }
                    }
                }
            }
        }

        consumerJob = viewModelScope.launch(Dispatchers.Default) {
            for (duration in timeDurationChannel) {
                mutex.withLock {
                    val isRecording = _uiState.value.recordingState is Recording
                    if (isRecording) {
                        _uiState.update { oldUiState ->
                            (oldUiState.recordingState as? Recording)?.let { oldRecordingState ->
                                oldUiState.copy(
                                    recordingState = oldRecordingState.copy(
                                        duration = RecordingDuration(oldRecordingState.duration.value + duration.milliseconds)
                                    )
                                )
                            } ?: oldUiState
                        }
                    }
                }
            }
        }
    }

    fun resumeRecording() {
        recorder?.resume()
        _uiState.update {
            it.copy(recordingState = Recording(it.recordingState.duration))
        }
    }

    fun pauseRecording() {
        recorder?.pause()
        _uiState.update {
            it.copy(recordingState = Paused(it.recordingState.duration))
        }
    }

    fun finishRecording() {
        recorder?.apply {
            stop()
            release()
        }
        viewModelScope.coroutineContext.cancelChildren()
        _uiState.update {
            it.copy(recordingState = DoneRecording(it.recordingState.duration))
        }
    }

    fun cancelRecording() {
        recorder?.apply {
            stop()
            release()
        }
        viewModelScope.coroutineContext.cancelChildren()
        _uiState.update {
            it.copy(recordingState = DoneRecording(RecordingDuration(Duration.ZERO)))
        }
    }

    private fun Context.generateFileTimestampName(
        prefix: String = "echo-journal", extension: String = "mp3"
    ): String {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        return "${externalCacheDir!!.absolutePath}/${prefix}_$timestamp.$extension".also {
            println("KALLENDORIUS - $it")
        }
    }
}