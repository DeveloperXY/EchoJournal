package com.developerxy.domain

import com.developerxy.domain.model.Mood
import kotlinx.coroutines.flow.Flow

interface MoodRepository {
    fun getDefaultNewEntryMood(): Flow<Mood>
    suspend fun setDefaultNewEntryMood(mood: Mood)
}