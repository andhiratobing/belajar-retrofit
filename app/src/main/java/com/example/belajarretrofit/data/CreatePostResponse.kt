package com.example.belajarretrofit.data

import com.google.gson.annotations.SerializedName

data class CreatePostResponse(
    var user_id: String,
    var id: Int,
    var title: String,

    /**
     *Annotation SerializedName digunakan jika nama constructor tidak ingin sama
     * dengan nama variable API yang digunakan
     */

    @SerializedName("body")
    var text: String

)