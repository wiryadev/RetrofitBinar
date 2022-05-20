package com.sennohananto.retrofit.data.room

class DbHelper(private val postBookmarkDao: PostBookmarkDao) {

    suspend fun insert(post: PostEntity) = postBookmarkDao.insert(post)

}