package com.sennohananto.retrofit.data.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getAllPosts() = apiService.getAllPosts()
}