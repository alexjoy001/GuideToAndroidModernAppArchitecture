package com.example.guidemodernapparchitecture.data.remotedatasource

import com.example.guidemodernapparchitecture.network.ApiService
import javax.inject.Inject

class NewsDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun searchAnything(searchKeyWord: String) = apiService.searchAnything(searchKeyWord)

    suspend fun topHeadLines(country: String) = apiService.topHeadlines(country)

    suspend fun getCategoryNews(category: String) = apiService.getCategoryNews(category)

}