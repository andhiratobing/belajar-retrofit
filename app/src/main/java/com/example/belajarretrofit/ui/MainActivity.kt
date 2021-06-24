package com.example.belajarretrofit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.belajarretrofit.databinding.ActivityMainBinding
import com.example.belajarretrofit.ui.comments.CommentsActivity
import com.example.belajarretrofit.ui.post.PostActivity

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPost.setOnClickListener{
                val intent = Intent(this@MainActivity, PostActivity::class.java)
                startActivity(intent)
            }
            btnComments.setOnClickListener{
                val intent = Intent(this@MainActivity, CommentsActivity::class.java)
                startActivity(intent)
            }
        }

    }

}