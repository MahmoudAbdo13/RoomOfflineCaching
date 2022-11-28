package com.mahmoud.offlinecaching.features.restaurants

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahmoud.offlinecaching.databinding.ActivityRestaurantBinding
import com.mahmoud.offlinecaching.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            viewModel.news.observe(this@RestaurantActivity) { result ->
                //result.data?.get(0)?.let { Log.e("viewModel.news", it.title) }
                restaurantAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewErrorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewErrorMessage.text = result.error?.localizedMessage

            }
        }
    }
}