package com.mahmoud.offlinecaching.data

import androidx.room.TypeConverter
import com.mahmoud.offlinecaching.data.data.Media

class Converters {
    @TypeConverter
    fun fromall_awardings(media: List<Media>): String{
        return media[0].icon_url
    }

    @TypeConverter
    fun toall_awardings(icon_url: String): List<Media>{
        val list = ArrayList<Media>()
        val media = Media(icon_url)
        list.add(media)
        return list
    }

}