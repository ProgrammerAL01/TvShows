package com.example.tvshowpro.data.event

import com.example.tvshowpro.data.model.TvShowsItem

interface ItemTvShowClickListener {
    fun onItemClick(model: TvShowsItem)
}