package pro.basked.exmgetrequest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pro.basked.exmgetrequest.model.Post
import pro.basked.exmgetrequest.repository.Repository
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponce: MutableLiveData<Response<Post>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {

            val response: Response<Post> = repository.getPost()
            myResponce.value =response
        }
    }
}