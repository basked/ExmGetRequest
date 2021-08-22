package pro.basked.exmgetrequest.repository

import pro.basked.exmgetrequest.api.RetrofitInstance
import pro.basked.exmgetrequest.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}