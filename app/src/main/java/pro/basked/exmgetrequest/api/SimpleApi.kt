package pro.basked.exmgetrequest.api

import pro.basked.exmgetrequest.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost():Post

}