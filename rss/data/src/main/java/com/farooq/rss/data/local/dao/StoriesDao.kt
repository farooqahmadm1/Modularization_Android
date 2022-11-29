package com.farooq.rss.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farooq.rss.data.local.model.StoriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<StoriesEntity>)

    @Query("SELECT * FROM stories_entity WHERE category = :category")
    fun getStories(category: String): Flow<List<StoriesEntity>>
}