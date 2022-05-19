package com.sennohananto.retrofit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.Resource
import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _posts = MutableLiveData<Resource<List<GetAllPostsResponseItem>>>()
    val posts: LiveData<Resource<List<GetAllPostsResponseItem>>>
        get() = _posts

    fun getAllPosts() {
        viewModelScope.launch {
            _posts.postValue(Resource.loading())
            try {
                _posts.postValue(Resource.success(repository.getPosts()))
            } catch (exception: Exception) {
                _posts.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}