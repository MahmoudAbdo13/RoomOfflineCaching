package com.mahmoud.offlinecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mahmoud.offlinecaching.data.data.ChildrenData

@Database(entities = [ChildrenData::class], version = 1)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase(){

    abstract fun newsDao(): NewsDao
}