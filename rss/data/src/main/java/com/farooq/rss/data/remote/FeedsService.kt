package com.farooq.rss.data.remote


import com.farooq.rss.data.remote.dto.FeedsDto
import retrofit2.http.GET

interface FeedsService {

    @GET("rss")
    suspend fun getFeeds(): FeedsDto

}