package com.example.api.model.Remot


import com.example.api.PostData
import com.example.api.SetData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

public interface ServesAPI {

    @GET("posts")
   //  fun getPost(@Query("id") id: String): Call<Post>
    fun getPost(@Query("id") id: String): Call<List<PostData>>
  @POST("posts")
  fun setPost(@Body postData: SetData): Call<PostData>


}