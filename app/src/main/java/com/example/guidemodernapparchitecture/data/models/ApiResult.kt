package com.example.guidemodernapparchitecture.data.models

sealed class ApiResult {
    class Success<out T: Any>(val message: String, val data: T?): ApiResult()
    class Error(val errorMessage: String): ApiResult()
}