package com.mahmoud.offlinecaching.data

import androidx.room.*
import com.mahmoud.offlinecaching.data.data.ChildrenData
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

   @Query("SELECT * FROM kotlinNews")
   fun getAllNews(): Flow<List<ChildrenData>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertNews(news: List<ChildrenData>)

   @Query("DELETE FROM kotlinNews")
   suspend fun deleteAllNews()
}