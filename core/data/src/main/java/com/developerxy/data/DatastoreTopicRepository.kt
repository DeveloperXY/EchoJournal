package com.developerxy.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.developerxy.domain.TopicRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class DatastoreTopicRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : TopicRepository {

    private val topicsKey = stringPreferencesKey("topics")
    private val defaultTopicsKey = stringPreferencesKey("default_topics")

    override fun getAllTopics(): Flow<Set<String>> {
        return dataStore.data.map { prefs ->
            prefs[topicsKey]?.let {
                Json.decodeFromString<Set<String>>(it)
            } ?: emptySet()
        }
    }

    override fun getDefaultTopics(): Flow<Set<String>> {
        return dataStore.data.map { prefs ->
            prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<Set<String>>(it)
            } ?: emptySet()
        }
    }

    override suspend fun addTopic(topic: String) {
        dataStore.edit { prefs ->
            val existingTopics = prefs[topicsKey]?.let {
                Json.decodeFromString<Set<String>>(it)
            } ?: emptyList()

            with(existingTopics.toMutableSet()) {
                add(topic)
                prefs[topicsKey] = Json.encodeToString(this)
            }
        }
    }

    override suspend fun addDefaultTopic(topic: String) {
        dataStore.edit { prefs ->
            val defaultTopics = prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<Set<String>>(it)
            } ?: emptyList()

            with(defaultTopics.toMutableSet()) {
                add(topic)
                prefs[defaultTopicsKey] = Json.encodeToString(this)
            }
        }
    }

    override suspend fun removeDefaultTopic(topic: String) {
        dataStore.edit { prefs ->
            val defaultTopics = prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<Set<String>>(it)
            } ?: emptyList()

            with(defaultTopics.toMutableSet()) {
                remove(topic)
                prefs[defaultTopicsKey] = Json.encodeToString(this)
            }
        }
    }
}