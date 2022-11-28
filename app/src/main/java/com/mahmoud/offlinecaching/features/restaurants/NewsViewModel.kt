package com.mahmoud.offlinecaching.features.restaurants

import android.util.Log
import androidx.lifecycle.*
import com.mahmoud.offlinecaching.api.NewsApi
import com.mahmoud.offlinecaching.data.NewsRepository
import com.mahmoud.offlinecaching.data.data.ChildrenData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(repository: NewsRepository) : ViewModel() {
    val news = repository.getNews().asLiveData()

/*
     private val restaurantLiveData = MutableLiveData<List<ChildrenData>>()
     val restaurants: LiveData<List<ChildrenData>> = restaurantLiveData
     init {
         viewModelScope.launch {
             val restaurants = api.getAllNews()
             val news =  ArrayList<ChildrenData>()
             for (model in restaurants.data.children){
                 news.add(model.data)
                 Log.e("saveFetchResult", model.data.title)
                 Log.e("news news", news[0].title)
             }
             restaurantLiveData.value = news
         }
     }*/
}