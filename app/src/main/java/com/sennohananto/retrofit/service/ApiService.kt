package com.sennohananto.retrofit.service

import com.sennohananto.retrofit.model.GetAllCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>
}