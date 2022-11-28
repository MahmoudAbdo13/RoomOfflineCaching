package com.mahmoud.offlinecaching.data

import android.util.Log
import androidx.room.withTransaction
import com.mahmoud.offlinecaching.api.NewsApi
import com.mahmoud.offlinecaching.data.data.ChildrenData
import com.mahmoud.offlinecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApi,
    private val db: NewsDatabase
) {
    private val newsDao = db.newsDao()
    fun getNews() = networkBoundResource(
        query = {
            newsDao.getAllNews()
        },
        fetch = {
            delay(2000)
            Log.e("fetch", "model.data.children[0].data.title")
            api.getAllNews()

        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                val news =  ArrayList<ChildrenData>()
                for (model in restaurants.data.children){
                    news.add(model.data)
                    Log.e("saveFetchResult", model.data.title)
                    Log.e("saveFetchResult", model.data.all_awardings[0].icon_url)
                    Log.e("news news", news[0].title)
                }
                newsDao.deleteAllNews()
                newsDao.insertNews(news)
            }
        }
    )
}