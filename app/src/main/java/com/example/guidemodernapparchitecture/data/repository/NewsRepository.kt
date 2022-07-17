package com.example.guidemodernapparchitecture.data.repository

import com.example.guidemodernapparchitecture.data.remotedatasource.NewsDataSource
import com.example.guidemodernapparchitecture.data.models.ApiResult
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import com.example.guidemodernapparchitecture.util.Constants
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val dataSource: NewsDataSource
) {

    suspend fun searchAnything(searchKeyWord: String): ApiResult {
        return try {
            val response = dataSource.searchAnything(searchKeyWord)
            if (response.status == Constants.OK) {
                val newsList: List<NewsUi> = response.articles?.map {
                    NewsUi().getNewsFromNewsApi(newsApiResponse = it)
                }!!.toMutableList()
                ApiResult.Success(message = "is success response", data = newsList)
            } else {
                ApiResult.Error(errorMessage = "Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(errorMessage = "API Error")
        }
    }

    suspend fun topHeadLines(country: String): ApiResult {
        return try {
            val response = dataSource.topHeadLines(country)
            if (response.status == Constants.OK) {

                val newsList: List<NewsUi>? = response.articles?.map {
                    NewsUi().getNewsFromNewsApi(newsApiResponse = it)
                }

                ApiResult.Success(message = "is success response", data = newsList)
            } else {
                ApiResult.Error(errorMessage = "Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(errorMessage = "API Error")
        }
    }

    suspend fun getCategoryNews(category: String): ApiResult {
        return try {
            val response = dataSource.getCategoryNews(category = category)
            if (response.status == Constants.OK) {
                val newsList: List<NewsUi> = response.articles?.map {
                    NewsUi().getNewsFromNewsApi(newsApiResponse = it)
                }!!.toMutableList()
                ApiResult.Success(message = "is success response", data = newsList)
            } else {
                ApiResult.Error(errorMessage = "Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(errorMessage = "API Error")
        }
    }
}