package com.sennohananto.retrofit.data

import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import com.sennohananto.retrofit.data.room.DbHelper
import com.sennohananto.retrofit.data.service.ApiHelper
import com.sennohananto.retrofit.data.service.ApiService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test


class RepositoryTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    private lateinit var service: ApiService

    @InjectMockKs
    private lateinit var apiHelper: ApiHelper

    @MockK
    private lateinit var dbHelper: DbHelper

    @InjectMockKs
    private lateinit var repo: Repository

    @Test
    fun getUsers() = runBlocking {
        val response = mockk<List<GetAllPostsResponseItem>>()

        every {
            runBlocking {
                service.getAllPosts()
            }
        } returns response

        repo.getPosts()

        verify {
            runBlocking {
                service.getAllPosts()
            }
        }
    }

}