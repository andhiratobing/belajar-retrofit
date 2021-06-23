package com.example.belajarretrofit

import com.example.belajarretrofit.data.CreatePostResponse
import com.example.belajarretrofit.data.PostResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("posts")
    fun getPost(): Call<ArrayList<PostResponse>>

    //Annotation for @POST
    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        //Field in Spec Endpoint
        @Field("user_id") user_id: String,
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<CreatePostResponse>

}