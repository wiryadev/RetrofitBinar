package com.sennohananto.retrofit.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sennohananto.retrofit.data.Status
import com.sennohananto.retrofit.databinding.ActivityMainBinding
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var progressDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)

        binding.btnGetAllPosts.setOnClickListener {
            viewModel.getAllPosts()
        }

        setupObservers()
    }

    fun setupObservers(){
        viewModel.posts.observe(this){ resource ->
            when(resource.status){
                Status.LOADING -> {
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                }

                Status.SUCCESS -> {
                    Toast.makeText(this, "Response Sukses : ${resource.data?.get(0)?.title}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error get Data : ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}