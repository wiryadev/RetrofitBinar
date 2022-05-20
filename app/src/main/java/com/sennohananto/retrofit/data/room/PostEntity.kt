package com.sennohananto.retrofit.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_post")
data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "body")
    val body: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "userId")
    val userId: Int
)