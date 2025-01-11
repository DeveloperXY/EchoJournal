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
import javax.inject.Singleton

@Singleton
class DatastoreTopicRepository(
    private val dataStore: DataStore<Preferences>
) : TopicRepository {

    private val topicsKey = stringPreferencesKey("topics")
    private val defaultTopicsKey = stringPreferencesKey("default_topics")

    override fun getAllTopics(): Flow<List<String>> {
        return dataStore.data.map { prefs ->
            prefs[topicsKey]?.let {
                Json.decodeFromString<List<String>>(it)
            } ?: emptyList()
        }
    }

    override fun getDefaultTopics(): Flow<List<String>> {
        return dataStore.data.map { prefs ->
            prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<List<String>>(it)
            } ?: emptyList()
        }
    }

    override suspend fun addTopic(topic: String) {
        dataStore.edit { prefs ->
            val existingTopics = prefs[topicsKey]?.let {
                Json.decodeFromString<List<String>>(it)
            } ?: emptyList()

            with(existingTopics.toMutableList()) {
                add(topic)
                prefs[topicsKey] = Json.encodeToString(this)
            }
        }
    }

    override suspend fun addDefaultTopic(topic: String) {
        dataStore.edit { prefs ->
            val defaultTopics = prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<List<String>>(it)
            } ?: emptyList()

            with(defaultTopics.toMutableList()) {
                add(topic)
                prefs[defaultTopicsKey] = Json.encodeToString(this)
            }
        }
    }

    override suspend fun removeDefaultTopic(topic: String) {
        dataStore.edit { prefs ->
            val defaultTopics = prefs[defaultTopicsKey]?.let {
                Json.decodeFromString<List<String>>(it)
            } ?: emptyList()

            with(defaultTopics.toMutableList()) {
                remove(topic)
                prefs[defaultTopicsKey] = Json.encodeToString(this)
            }
        }
    }
}