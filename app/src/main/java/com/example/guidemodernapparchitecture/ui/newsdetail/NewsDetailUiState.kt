package com.example.guidemodernapparchitecture.ui.newsdetail

import com.example.guidemodernapparchitecture.ui.models.NewsSourceUi

data class NewsDetailUiState(
    var source: NewsSourceUi? = null,
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)