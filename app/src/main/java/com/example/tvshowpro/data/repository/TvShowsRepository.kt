package com.example.tvshowpro.data.repository

import com.example.tvshowpro.data.service.ApiService
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}