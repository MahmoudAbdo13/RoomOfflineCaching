package com.mahmoud.offlinecaching.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kotlinNews")
data class ChildrenData(
    @PrimaryKey var title: String,
    var selftext: String,
    var all_awardings: List<Media>
) {
}