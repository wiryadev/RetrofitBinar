package com.sennohananto.retrofit.ui

import android.app.Application
import androidx.lifecycle.*
import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.Resource
import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import com.sennohananto.retrofit.data.service.ApiClient
import com.sennohananto.retrofit.data.service.ApiHelper
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.coroutineContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
//    val repository = Repository(ApiHelper(ApiClient.getInstance(getApplication())))
    val repository = Repository(ApiHelper(ApiClient.getInstance(getApplication())))
    private val _posts = MutableLiveData<Resource<List<GetAllPostsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllPostsResponseItem>>>
    get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(Resource.loading())
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}