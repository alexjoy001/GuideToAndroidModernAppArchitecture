package com.example.guidemodernapparchitecture.ui.categorynews

import com.example.guidemodernapparchitecture.ui.models.NewsUi

data class CategoryNewsUiState(
    val isLoading: Boolean = false,
    val newsList: List<NewsUi> = listOf(),
    val errorMessage: String = ""
)