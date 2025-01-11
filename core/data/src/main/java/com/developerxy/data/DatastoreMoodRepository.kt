package com.developerxy.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.developerxy.domain.MoodRepository
import com.developerxy.domain.model.Mood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
class DatastoreMoodRepository(
    private val dataStore: DataStore<Preferences>
) : MoodRepository {

    private val defaultMoodKey = stringPreferencesKey("default_mood")

    override fun getDefaultNewEntryMood(): Flow<Mood> {
        return dataStore.data.map { prefs ->
            Mood.valueOf(prefs[defaultMoodKey] ?: Mood.EXCITED.name)
        }
    }

    override suspend fun setDefaultNewEntryMood(mood: Mood) {
        dataStore.edit { prefs ->
            prefs[defaultMoodKey] = mood.name
        }
    }
}