package com.example.guidemodernapparchitecture.ui.businessnews

import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse


data class BusinessNewsUiState(
    val isLoading: Boolean = false,
    val newsList: List<NewsApiResponse> = listOf(),
    val errorMessage: String = ""
)