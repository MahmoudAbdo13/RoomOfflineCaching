package com.mahmoud.offlinecaching.api

import com.mahmoud.offlinecaching.data.data.DataModel
import retrofit2.http.GET

interface NewsApi {
    companion object{
        const val BASE_URI = "https://www.reddit.com/r/kotlin/"
    }

    @GET(".json")
    suspend fun getAllNews(): DataModel
}