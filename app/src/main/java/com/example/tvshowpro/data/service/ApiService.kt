package com.example.tvshowpro.data.service

import com.example.tvshowpro.data.model.TvShowsResponse
import com.example.tvshowpro.utils.Constance
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value = Constance.END_POINT)
    suspend fun getTvShows(): Response<TvShowsResponse>
}