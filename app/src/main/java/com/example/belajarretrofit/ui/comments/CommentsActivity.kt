package com.example.belajarretrofit.ui.comments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarretrofit.RetrofitClient
import com.example.belajarretrofit.data.CommentsResponse
import com.example.belajarretrofit.data.PostResponse
import com.example.belajarretrofit.databinding.ActivityCommentsBinding
import com.example.belajarretrofit.ui.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentsBinding
    private val commentsList = ArrayList<CommentsResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        getComments()
    }

    private fun getComments() {
        binding.apply {
            //call retrofit client
            RetrofitClient.instance.getComments(1).enqueue(object : Callback<ArrayList<CommentsResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<CommentsResponse>>,
                    response: Response<ArrayList<CommentsResponse>>
                ) {
                    //call response code
                    val responseCode = response.code()
                    tvResponse.text = "Response code: $responseCode"
                    //call list
                    response.body()?.let { commentsList.addAll(it)
                        Log.d("Comment List", "Berhasil menampilkan list comments")
                    }
                }

                override fun onFailure(call: Call<ArrayList<CommentsResponse>>, t: Throwable) {
                    tvResponse.text = t.message
                }
            })
        }
    }


    private fun setAdapter(){
        binding.apply {
            rvComments.setHasFixedSize(true)
            rvComments.layoutManager = LinearLayoutManager(this@CommentsActivity)
            val adapter = CommentsAdapter(commentsList)
            rvComments.adapter = adapter
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}