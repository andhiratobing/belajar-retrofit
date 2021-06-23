package com.example.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarretrofit.data.CreatePostResponse
import com.example.belajarretrofit.data.PostResponse
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
//        getPost()
        createPost()
    }

    private fun createPost() {
        binding.apply {
            RetrofitClient.instance.createPost(
                "1",
                "Belajar",
                "Belajar Retrofit"
            ).enqueue(object : Callback<CreatePostResponse> {
                override fun onResponse(
                    call: Call<CreatePostResponse>,
                    response: Response<CreatePostResponse>
                ) {
                    tvResponse.text = "Response code: ${response.code()}\n" +
                            "User id: ${response.body()?.user_id}\n" +
                            "id: ${response.body()?.id}\n" +
                            "title: ${response.body()?.title}\n" +
                            "text: ${response.body()?.text}\n"
                }

                override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                    binding.apply {
                        tvResponse.text = t.message
                    }
                }

            })
        }
    }


    private fun getPost() {
        binding.apply {
            //call retrofit client
            RetrofitClient.instance.getPost().enqueue(object : Callback<ArrayList<PostResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<PostResponse>>,
                    response: Response<ArrayList<PostResponse>>
                ) {
                    //call response code
                    val responseCode = response.code()
                    tvResponse.text = "$responseCode"
                    //call list
                    response.body()?.let { postList.addAll(it) }
                }

                override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    private fun setAdapter() {
        binding.apply {
            rvPost.setHasFixedSize(true)
            rvPost.layoutManager = LinearLayoutManager(this@MainActivity)
            val adapter = PostAdapter(postList)
            rvPost.adapter = adapter
        }
    }
}