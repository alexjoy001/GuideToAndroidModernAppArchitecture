package com.example.guidemodernapparchitecture.data.repository

import android.util.Log
import com.example.guidemodernapparchitecture.data.remotedatasource.NewsDataSource
import com.example.guidemodernapparchitecture.models.ApiResult
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val dataSource: NewsDataSource
) {

    suspend fun searchAnything(searchKeyWord: String): ApiResult  {
        return try {
            val response = dataSource.searchAnything(searchKeyWord)
            if (response.status == "ok") {
                ApiResult.Success(message = "is success response", data = response.articles)
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
            if (response.status == "ok") {
                ApiResult.Success(message = "is success response", data = response.articles)
            } else {
                ApiResult.Error(errorMessage = "Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(errorMessage = "API Error")
        }
    }

    suspend fun getBusinessNews(): ApiResult {
        return try {
            val retrofitResponse = dataSource.businessNews()
            if (retrofitResponse.isSuccessful) {
                val response = retrofitResponse.body()
                if (response?.status == "ok") {
                    ApiResult.Success(message = "is success response", data = response.articles)
                } else {
                    ApiResult.Error(errorMessage = "Error")
                }
            } else {
                retrofitResponse.errorBody()?.let {
                    val jsonObj = JSONObject(it.charStream().readText())
                    Log.d("BLAA ", jsonObj.toString())
                } ?: kotlin.run {
                    Log.d("No Error ", "body")
                }
                val jsonObj = JSONObject(retrofitResponse.errorBody().toString())
                Log.d("Retrofit Error ==>", jsonObj.toString())
                ApiResult.Error(errorMessage = jsonObj.toString())
            }
        } catch (e: Exception) {
            Log.d("Exception => ", e.localizedMessage)
            ApiResult.Error(errorMessage = "API Error")
        }
    }

    suspend fun getScienceNews(): ApiResult {
        return try {
            val response = dataSource.scienceNews()
            if (response.status == "ok") {
                ApiResult.Success(message = "is success response", data = response.articles)
            } else {
                ApiResult.Error(errorMessage = "Error")
            }
        } catch (e: Exception) {
            ApiResult.Error(errorMessage = "API Error")
        }
    }
}