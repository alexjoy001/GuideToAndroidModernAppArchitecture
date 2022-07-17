package com.example.guidemodernapparchitecture.ui.topheadlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guidemodernapparchitecture.domain.TopHeadlinesUseCase
import com.example.guidemodernapparchitecture.data.models.ApiResult
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlineViewModel @Inject constructor(
    private val useCase: TopHeadlinesUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(TopHeadlineUiState())

    val topHeadLineUi: StateFlow<TopHeadlineUiState> = _uiState.asStateFlow()

    private var job: Job? = null

    init {
        getTopHeadline(country = "in")
    }

    private fun getTopHeadline(country: String) {
        job?.cancel()
        job = viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when(val apiResult = useCase.invoke(country)) {
                is ApiResult.Success<*> -> {_uiState.update { it.copy(isLoading = false, newsList = apiResult.data as List<NewsUi>) }}
                is ApiResult.Error -> {_uiState.update { it.copy(isLoading = false, errorMessage = apiResult.errorMessage ) }}
            }
        }
    }
}