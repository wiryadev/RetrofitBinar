package com.sennohananto.retrofit.data.model


import com.google.gson.annotations.SerializedName

data class GetAllPostsResponseItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)