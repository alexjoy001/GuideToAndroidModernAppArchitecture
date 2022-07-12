package com.example.guidemodernapparchitecture.network

import com.example.guidemodernapparchitecture.models.BaseResponse
import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

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
    suspend fun businessNews(
        @Query("category") sortBy: String = "business",
        @Query("apiKey") apiKey: String = EndPoints.API_KEY
    ): Response<BaseResponse<List<NewsApiResponse>>>

    @GET(EndPoints.TOP_HEADLINES)
    suspend fun scienceNews(
        @Query("category") sortBy: String = "science",
        @Query("apiKey") apiKey: String = EndPoints.API_KEY
    ): BaseResponse<List<NewsApiResponse>>


}