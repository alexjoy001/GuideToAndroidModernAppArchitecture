package com.example.guidemodernapparchitecture.data.models.apiresponsemodels

import com.google.gson.annotations.SerializedName

data class NewsSourceApiResponse(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)