package com.mahmoud.offlinecaching.data

import androidx.room.TypeConverters
import com.mahmoud.offlinecaching.data.data.SecureMedia

class Converter {
    @TypeConverters
    fun fromSecureMedia(secureMedia: SecureMedia): SecureMedia.Oembed{
        return secureMedia.oembed
    }

    @TypeConverters
    fun toSecureMedia(oembed: SecureMedia.Oembed): SecureMedia{
        return SecureMedia(oembed, oembed.thumbnailUrl)
    }

    @TypeConverters
    fun fromOembed(secureMedia: SecureMedia): String{
        return secureMedia.oembed.thumbnailUrl
    }

    @TypeConverters
    fun toOembed(thumbnailUrl: String): SecureMedia.Oembed{
        return SecureMedia.Oembed(thumbnailUrl)
    }
}