package com.farooq.rss.data.remote

import com.farooq.rss.data.remote.dto.FeedsDto
import com.farooq.rss.data.remote.dto.StoriesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoriesService {

    @GET("rss/{feedCategory}")
    suspend fun getStories(@Path("feedCategory") feedCategory : String): StoriesDto
}