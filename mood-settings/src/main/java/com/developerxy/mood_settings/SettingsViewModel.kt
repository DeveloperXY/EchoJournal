package com.developerxy.mood_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerxy.domain.MoodRepository
import com.developerxy.domain.TopicRepository
import com.developerxy.domain.model.Mood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val moodRepository: MoodRepository,
    private val topicRepository: TopicRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(SettingsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            moodRepository.getDefaultNewEntryMood()
                .collect {
                    updateDefaultMoodState(it)
                }
        }
        viewModelScope.launch {
            combine(
                topicRepository.getAllTopics(),
                topicRepository.getDefaultTopics()
            ) { allTopics, defaultTopics ->
                updateTopicsState(allTopics, defaultTopics)
            }.collect {}
        }
    }

    private fun updateTopicsState(allTopics: Set<String>, defaultTopics: Set<String>) {
        _uiState.update { currentState ->
            currentState.copy(
                topicsState = TopicsState(
                    savedTopics = allTopics,
                    defaultTopics = defaultTopics
                )
            )
        }
    }

    private fun updateDefaultMoodState(selectedMood: Mood?) {
        _uiState.update { currentState ->
            val updatedEntries = currentState.defaultMoodState.entries.map { moodEntry ->
                moodEntry.copy(isSelected = moodEntry.text == selectedMood?.name)
            }
            currentState.copy(
                defaultMoodState = currentState.defaultMoodState.copy(entries = updatedEntries)
            )
        }
    }

    fun toggleMood(targetMoodEntry: MoodEntry) {
        viewModelScope.launch {
            val newDefaultMood =
                if (targetMoodEntry.isSelected) null else Mood.valueOf(targetMoodEntry.text)
            moodRepository.setDefaultNewEntryMood(newDefaultMood)
        }
    }

    fun addDefaultTopic(topic: String) {
        viewModelScope.launch {
            topicRepository.addDefaultTopic(topic.trim())
        }
    }

    fun removeDefaultTopic(topic: String) {
        viewModelScope.launch {
            topicRepository.removeDefaultTopic(topic)
        }
    }

    fun setAsDefaultAndSaveTopic(topic: String) {
        viewModelScope.launch {
            topicRepository.apply {
                val newTopic = topic.trim()
                addDefaultTopic(newTopic)
                addTopic(newTopic)
            }
        }
    }
}