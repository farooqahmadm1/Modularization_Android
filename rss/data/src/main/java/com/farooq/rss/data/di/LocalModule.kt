package com.farooq.rss.data.di

import android.content.Context
import androidx.room.Room
import com.farooq.rss.data.local.AppDatabase
import com.farooq.rss.data.local.dao.FeedsDao
import com.farooq.rss.data.local.dao.StoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFeedsDao(appDatabase: AppDatabase): FeedsDao {
        return appDatabase.feedsDao()
    }

    @Provides
    @Singleton
    fun provideStoriesDao(appDatabase: AppDatabase): StoriesDao {
        return appDatabase.storiesDao()
    }
}