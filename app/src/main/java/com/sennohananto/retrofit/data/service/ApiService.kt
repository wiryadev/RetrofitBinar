package com.sennohananto.retrofit.data.service

import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<GetAllPostsResponseItem>
}