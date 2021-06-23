package com.example.belajarretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    /**
     * Create BASE_URL (use address API)
     */
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    /**
     * Create Instance for everywhere calling
     */
    val instance: Api by lazy {
        //Call retrofit builder
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //create retrofit
        retrofit.create(Api::class.java)
    }
}