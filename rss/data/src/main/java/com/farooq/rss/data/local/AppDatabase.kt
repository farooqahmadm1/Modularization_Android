package com.farooq.rss.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farooq.rss.data.local.dao.FeedsDao
import com.farooq.rss.data.local.dao.StoriesDao
import com.farooq.rss.data.local.model.FeedsEntity
import com.farooq.rss.data.local.model.StoriesEntity

@Database(
    entities = [
        StoriesEntity::class,
        FeedsEntity::class
    ], exportSchema = false, version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun feedsDao(): FeedsDao
    abstract fun storiesDao(): StoriesDao

}