package com.example.belajarretrofit.ui.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarretrofit.data.CommentsResponse
import com.example.belajarretrofit.databinding.ItemCommentsBinding


class CommentsAdapter(private val commentsList: ArrayList<CommentsResponse>)
    :RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>(){

    inner class CommentViewHolder(private val binding: ItemCommentsBinding)
        : RecyclerView.ViewHolder(binding.root){
            internal fun bind(commentsResponse: CommentsResponse){
                binding.apply {
                    tvPostId.text = "postID: ${commentsResponse.postId}"
                    tvId.text = "id: ${commentsResponse.id}"
                    tvEmail.text = "email: ${commentsResponse.email}"
                    tvName.text = "name: ${commentsResponse.name}"
                    tvText.text = "text: ${commentsResponse.text}"
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = ItemCommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val listComments = commentsList[position]
        holder.bind(listComments)
    }

    override fun getItemCount(): Int = commentsList.size
}