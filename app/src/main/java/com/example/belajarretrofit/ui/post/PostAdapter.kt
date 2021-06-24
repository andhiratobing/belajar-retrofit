package com.example.belajarretrofit.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarretrofit.data.PostResponse
import com.example.belajarretrofit.databinding.ItemPostBinding

class PostAdapter(private val postList: ArrayList<PostResponse>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    inner class PostViewHolder(private val binding: ItemPostBinding):
        RecyclerView.ViewHolder (binding.root){
            internal fun bind(postResponse: PostResponse){
                binding.apply {
                    tvId.text = "${postResponse.id}"
                    tvTitle.text = postResponse.title
                    tvText.text = postResponse.text
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val listPost = postList[position]
        holder.bind(listPost)
    }

    override fun getItemCount(): Int = postList.size
}