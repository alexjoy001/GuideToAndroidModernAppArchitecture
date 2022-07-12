package com.example.guidemodernapparchitecture.ui.searchanynews

import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse

data class SearchAnythingUiState(
    val isLoading: Boolean = false,
    val newsList: List<NewsApiResponse> = listOf()
)