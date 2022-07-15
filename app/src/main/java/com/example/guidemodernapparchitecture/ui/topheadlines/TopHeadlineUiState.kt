package com.example.guidemodernapparchitecture.ui.topheadlines

import com.example.guidemodernapparchitecture.ui.models.NewsUi

data class TopHeadlineUiState(
    var isLoading: Boolean = false,
    var newsList: List<NewsUi> = listOf(),
    var errorMessage: String = ""
)