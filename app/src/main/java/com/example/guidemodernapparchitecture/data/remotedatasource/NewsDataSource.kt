package com.example.guidemodernapparchitecture.data.remotedatasource

import com.example.guidemodernapparchitecture.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun searchAnything(searchKeyWord: String) =
        withContext(Dispatchers.IO) { apiService.searchAnything(searchKeyWord) }

    suspend fun topHeadLines(country: String) =
        withContext(Dispatchers.IO) { apiService.topHeadlines(country) }

    suspend fun businessNews() = withContext(Dispatchers.IO) { apiService.businessNews() }

    suspend fun scienceNews() = withContext(Dispatchers.IO) { apiService.scienceNews() }

}