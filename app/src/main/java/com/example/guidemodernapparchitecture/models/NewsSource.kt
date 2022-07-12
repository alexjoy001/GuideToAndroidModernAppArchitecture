package com.example.guidemodernapparchitecture.models

import com.google.gson.annotations.SerializedName

data class NewsSource(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)