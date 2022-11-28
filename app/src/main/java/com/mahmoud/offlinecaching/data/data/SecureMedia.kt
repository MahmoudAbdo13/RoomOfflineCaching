package com.mahmoud.offlinecaching.data.data

import com.google.gson.annotations.SerializedName

data class SecureMedia(
    val oembed: Oembed,
    val type: String
) {
    data class Oembed(
        val thumbnailUrl: String,
    )
}