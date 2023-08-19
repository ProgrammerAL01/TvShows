package com.example.tvshowpro.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.tvshowpro.data.event.ItemTvShowClickListener
import com.example.tvshowpro.data.model.TvShowsItem
import com.example.tvshowpro.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

class TvShowsViewHolder(private val binding: MovieItemBinding) : ViewHolder(binding.root) {
    fun bindViews(model: TvShowsItem,listener: ItemTvShowClickListener) {
        binding.apply {
            Picasso.get().load(model.image.original).into(binding.image)
            txtName.text = model.name
            txtRating.text = model.rating.average.toString()
            binding.image.setOnClickListener {
                listener.onItemClick(model)
            }
        }
    }
}