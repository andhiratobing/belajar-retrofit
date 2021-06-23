package com.example.belajarretrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPost(): Call<ArrayList<PostResponse>>
}