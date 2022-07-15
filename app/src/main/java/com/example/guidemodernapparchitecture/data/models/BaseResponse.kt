package com.example.guidemodernapparchitecture.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T: Any>(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var arcticles: T? = null
)