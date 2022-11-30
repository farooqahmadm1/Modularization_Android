package com.farooq.rss.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farooq.rss.data.local.model.FeedsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<FeedsEntity>)

    @Query("SELECT * FROM feeds_entity")
    fun getFeedsList(): Flow<List<FeedsEntity>>
}