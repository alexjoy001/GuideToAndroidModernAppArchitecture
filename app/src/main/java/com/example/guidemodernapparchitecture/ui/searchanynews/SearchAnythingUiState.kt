package com.example.guidemodernapparchitecture.ui.searchanynews

import com.example.guidemodernapparchitecture.ui.models.NewsUi

data class SearchAnythingUiState(
    val isLoading: Boolean = false,
    val newsList: List<NewsUi> = listOf()
)