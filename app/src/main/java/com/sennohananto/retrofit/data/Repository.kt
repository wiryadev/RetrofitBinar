package com.sennohananto.retrofit.data

import com.sennohananto.retrofit.data.service.ApiHelper

//(API, Room)
class Repository(private val apiHelper: ApiHelper) {
    suspend fun getPosts() = apiHelper.getAllPosts()

    //Edit Post

    //Delete Post

    //Login

    //Add Favourite
}