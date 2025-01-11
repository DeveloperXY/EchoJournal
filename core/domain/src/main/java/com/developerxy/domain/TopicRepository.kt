package com.developerxy.domain

import kotlinx.coroutines.flow.Flow

interface TopicRepository {
    fun getAllTopics(): Flow<List<String>>
    fun getDefaultTopics(): Flow<List<String>>
    suspend fun addTopic(topic: String)
    suspend fun addDefaultTopic(topic: String)
    suspend fun removeDefaultTopic(topic: String)
}