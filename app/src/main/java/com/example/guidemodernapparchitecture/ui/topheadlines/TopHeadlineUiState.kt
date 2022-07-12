package com.example.guidemodernapparchitecture.ui.topheadlines

import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse

data class TopHeadlineUiState(
    var isLoading: Boolean = false,
    var newsList: List<NewsApiResponse> = listOf(),
    var errorMessage: String = ""
)