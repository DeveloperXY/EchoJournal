package com.developerxy.data.di

import com.developerxy.data.DatastoreMoodRepository
import com.developerxy.data.DatastoreTopicRepository
import com.developerxy.domain.MoodRepository
import com.developerxy.domain.TopicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoreDataModule {

    @Binds
    internal abstract fun bindMoodRepository(impl: DatastoreMoodRepository): MoodRepository

    @Binds
    internal abstract fun bindTopicRepository(impl: DatastoreTopicRepository): TopicRepository
}