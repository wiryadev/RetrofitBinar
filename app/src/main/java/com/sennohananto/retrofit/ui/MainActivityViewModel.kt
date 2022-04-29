package com.sennohananto.retrofit.ui

import androidx.lifecycle.*
import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.Resource
import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import com.sennohananto.retrofit.data.service.ApiClient
import com.sennohananto.retrofit.data.service.ApiHelper
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel() : ViewModel() {
    val repository = Repository(ApiHelper(ApiClient.instance))
    private val _posts = MutableLiveData<Resource<List<GetAllPostsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllPostsResponseItem>>>
    get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(Resource.loading(null))
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(Resource.error(null, exception.message ?: "Error Occurred"))
            }
        }
    }
}