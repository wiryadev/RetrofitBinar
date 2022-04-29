package com.sennohananto.retrofit.data

import com.sennohananto.retrofit.data.service.ApiHelper

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getPosts() = apiHelper.getAllPosts()
}