package com.example.belajarretrofit.data

import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    /**
     *Annotation SerializedName digunakan jika nama constructor tidak ingin sama
     * dengan nama variable API yang digunakan
     */
    @SerializedName("body")
    var text: String
)
