package com.farooq.rss.data.di

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.farooq.rss.data.local.AppDatabase
import com.farooq.rss.data.local.dao.FeedsDao
import com.farooq.rss.data.local.dao.StoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [LocalModule::class]
)
class FakeLocalModule {

    @Provides
    fun providesRoomDb(): AppDatabase {
        val context = ApplicationProvider.getApplicationContext<Context>()
        return Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
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