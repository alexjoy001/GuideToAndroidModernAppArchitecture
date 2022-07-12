package com.example.guidemodernapparchitecture.ui.sciencenews

import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse

data class ScienceNewsUiState(
    val isLoading: Boolean = false,
    val newsList: List<NewsApiResponse> = listOf(),
    val errorMessage: String = ""
)