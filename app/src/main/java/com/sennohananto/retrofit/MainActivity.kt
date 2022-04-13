package com.sennohananto.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sennohananto.retrofit.databinding.ActivityMainBinding
import com.sennohananto.retrofit.model.GetAllCarResponseItem
import com.sennohananto.retrofit.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetAllCars.setOnClickListener {
            ApiClient.instance.getAllCar().enqueue(object : Callback<List<GetAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    Log.d("MOBIL", response.body()?.get(0)!!.name)
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {

                }
            })
        }
    }
}