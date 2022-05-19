package com.sennohananto.retrofit.ui

import androidx.lifecycle.*
import com.sennohananto.retrofit.data.Repository
import com.sennohananto.retrofit.data.Resource
import com.sennohananto.retrofit.data.model.GetAllPostsResponseItem
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

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

class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T
    }
}
