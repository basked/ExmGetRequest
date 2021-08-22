package pro.basked.exmgetrequest.repository

import pro.basked.exmgetrequest.api.RetrofitInstance
import pro.basked.exmgetrequest.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}