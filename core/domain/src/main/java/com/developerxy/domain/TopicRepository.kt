package com.developerxy.domain

import kotlinx.coroutines.flow.Flow

interface TopicRepository {
    fun getAllTopics(): Flow<Set<String>>
    fun getDefaultTopics(): Flow<Set<String>>
    suspend fun addTopic(topic: String)
    suspend fun addDefaultTopic(topic: String)
    suspend fun removeDefaultTopic(topic: String)
}