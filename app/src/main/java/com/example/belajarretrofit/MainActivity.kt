package com.example.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postList = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
    }


    private fun setAdapter() {
        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(this@MainActivity)

            //call retrofit client
            RetrofitClient.instance.getPost().enqueue(object : Callback<ArrayList<PostResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<PostResponse>>,
                    response: Response<ArrayList<PostResponse>>
                ) {
                    //call response code
                    val responseCode = response.code().toString()
                    tvResponse.text = responseCode
                    //call list
                    response.body()?.let { postList.addAll(it) }
                    //call adapter
                    val adapter = PostAdapter(postList)
                    rvPost.adapter = adapter
                }

                override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }


    }
}