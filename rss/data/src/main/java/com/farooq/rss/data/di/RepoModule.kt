package com.farooq.rss.data.di

import com.farooq.rss.data.repository.FeedRepoImpl
import com.farooq.rss.data.repository.StoriesRepoImpl
import com.farooq.rss.domain.repository.FeedRepo
import com.farooq.rss.domain.repository.StoriesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun provideFeedsRepo(feedRepoImpl: FeedRepoImpl): FeedRepo

    @Binds
    @Singleton
    abstract fun provideStoriesRepo(storiesRepoImpl: StoriesRepoImpl): StoriesRepo
}