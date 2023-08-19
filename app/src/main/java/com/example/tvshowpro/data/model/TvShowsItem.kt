package com.example.tvshowpro.data.model

import com.example.tvshowpro.data.model.Image
import com.example.tvshowpro.data.model.Rating


data class TvShowsItem(
    val averageRuntime: Int,
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val language: String,
    val name: String,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val summary: String,
    val url: String,
)
