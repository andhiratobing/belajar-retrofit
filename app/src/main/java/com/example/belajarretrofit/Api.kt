package com.example.belajarretrofit

import com.example.belajarretrofit.data.CommentsResponse
import com.example.belajarretrofit.data.CreatePostResponse
import com.example.belajarretrofit.data.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface Api {
    /**
     * Function or method get post basic
     */
//    @GET("posts")
//    fun getPost(): Call<ArrayList<PostResponse>>

    /**
     * Manipulation URL Query getPost()
     */
//    @GET("posts")
//    fun getPost(
//        @Query("userId") userId: Int,
//        @Query("id") id: Int): Call<ArrayList<PostResponse>>


    /**
     * Manipulation URL Query Map
     * use simple calling EndPoint
     */
//    @GET("posts")
//    fun getPost(
//        @QueryMap param: HashMap<String, String>)
//        : Call<ArrayList<PostResponse>>


    /**
     * Manipulation URL from Activity
     */
    @GET
    fun getPost(
        @Url url: String): Call<ArrayList<PostResponse>>


    /**
     * Function or method get comments basic
     */
//    @GET("posts/1/comments")
//    fun getComments(): Call<ArrayList<CommentsResponse>>
    /**
     * Manipulation URL Path getComments()
     */
    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int): Call<ArrayList<CommentsResponse>>

    //Annotation for @POST
    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        //Field in Spec Endpoint
        @Field("userId") userId: String,
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<CreatePostResponse>

}