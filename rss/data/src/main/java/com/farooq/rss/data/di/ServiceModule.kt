package com.farooq.rss.data.di

import com.farooq.rss.data.remote.FeedsService
import com.farooq.rss.data.remote.StoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun createFeedsService(retrofit: Retrofit): FeedsService {
        return retrofit.create(FeedsService::class.java)
    }

    @Provides
    @Singleton
    fun createStoriesService(retrofit: Retrofit): StoriesService {
        return retrofit.create(StoriesService::class.java)
    }
}