package com.example.guidemodernapparchitecture.ui.sciencenews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guidemodernapparchitecture.domain.ScienceNewsUseCase
import com.example.guidemodernapparchitecture.models.ApiResult
import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse
import com.example.guidemodernapparchitecture.ui.businessnews.BusinessNewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScienceNewsViewModel @Inject constructor(
    private val useCase: ScienceNewsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ScienceNewsUiState())

    val scienceNewsUi: StateFlow<ScienceNewsUiState> = _uiState.asStateFlow()

    private var job: Job? = null

    init {
        getScienceNews()
    }

    private fun getScienceNews() {
        job?.cancel()
        job = viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when(val apiResult = useCase.invoke()) {
                is ApiResult.Success<*> -> {
                    _uiState.update { it.copy(isLoading = false, newsList = apiResult.data as List<NewsApiResponse>) }
                }
                is ApiResult.Error -> {
                    _uiState.update { it.copy(isLoading = false, errorMessage = apiResult.errorMessage) }
                }
            }
        }
    }

}