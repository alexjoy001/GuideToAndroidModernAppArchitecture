package com.example.guidemodernapparchitecture.ui.newsdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(NewsDetailUiState())

    val newsDetailUi: StateFlow<NewsDetailUiState> = _uiState.asStateFlow()

    fun setNewsDetail(newsUi: NewsUi) {

        Log.d("HHH ", newsUi.source?.name.toString())
        _uiState.update {
            it.copy(
                source = newsUi.source,
                author = newsUi.author,
                title = newsUi.title,
                description = newsUi.description,
                url = newsUi.url,
                urlToImage = newsUi.urlToImage,
                publishedAt = newsUi.publishedAt,
                content = newsUi.content
            )
        }
    }
}