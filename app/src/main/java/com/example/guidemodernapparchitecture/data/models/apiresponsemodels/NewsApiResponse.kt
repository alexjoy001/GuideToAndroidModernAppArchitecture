package com.example.guidemodernapparchitecture.data.models.apiresponsemodels

import com.google.gson.annotations.SerializedName

data class NewsApiResponse(
    @SerializedName("source")
    var source: NewsSourceApiResponse?,
    @SerializedName("author")
    var author: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("urlToImage")
    var urlToImage: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("content")
    var content: String?
)