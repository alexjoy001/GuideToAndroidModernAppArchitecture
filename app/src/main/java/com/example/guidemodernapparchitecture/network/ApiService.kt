package com.example.guidemodernapparchitecture.network

import com.example.guidemodernapparchitecture.data.models.BaseResponse
import com.example.guidemodernapparchitecture.data.models.apiresponsemodels.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(EndPoints.SEARCH_NEWS)
    suspend fun searchAnything(
        @Query("q") searchKeyWord: String,
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = EndPoints.API_KEY
    ): BaseResponse<List<NewsApiResponse>>

    @GET(EndPoints.TOP_HEADLINES)
    suspend fun topHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = EndPoints.API_KEY
    ): BaseResponse<List<NewsApiResponse>>

    @GET(EndPoints.TOP_HEADLINES)
    suspend fun getCategoryNews(
        @Query("category") sortBy: String,
        @Query("apiKey") apiKey: String = EndPoints.API_KEY
    ): BaseResponse<List<NewsApiResponse>>

}