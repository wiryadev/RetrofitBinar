package com.sennohananto.retrofit.data

import com.sennohananto.retrofit.data.room.DbHelper
import com.sennohananto.retrofit.data.room.PostEntity
import com.sennohananto.retrofit.data.service.ApiHelper

//(API, Room)
class Repository(
    private val apiHelper: ApiHelper,
    private val dbHelper: DbHelper,
) {
    suspend fun getPosts() = apiHelper.getAllPosts()

    suspend fun bookmarkPost(post: PostEntity) = dbHelper.insert(post)

    //Edit Post

    //Delete Post

    //Login

    //Add Favourite
}