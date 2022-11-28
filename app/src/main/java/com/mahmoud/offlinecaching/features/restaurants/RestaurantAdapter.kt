package com.mahmoud.offlinecaching.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmoud.offlinecaching.data.data.ChildrenData
import com.mahmoud.offlinecaching.databinding.RestaurantItemBinding

class RestaurantAdapter: ListAdapter<ChildrenData, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(newsItem: ChildrenData){
                binding.apply {
                    Glide.with(itemView).load(newsItem.all_awardings[0].icon_url).into(logo)
                    textViewName.text = newsItem.title
                    textViewType.text = newsItem.title
                    textViewAddress.text = newsItem.title
                }
            }
        }

    class RestaurantComparator : DiffUtil.ItemCallback<ChildrenData>(){
        override fun areItemsTheSame(oldItem: ChildrenData, newItem: ChildrenData) = oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: ChildrenData, newItem: ChildrenData) = oldItem == newItem

    }
}