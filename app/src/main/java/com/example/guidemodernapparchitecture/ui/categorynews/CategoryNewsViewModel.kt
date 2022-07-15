package com.example.guidemodernapparchitecture.ui.categorynews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.guidemodernapparchitecture.domain.ScienceNewsUseCase
import com.example.guidemodernapparchitecture.data.models.ApiResult
import com.example.guidemodernapparchitecture.domain.BusinessNewsUseCase
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import com.example.guidemodernapparchitecture.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryNewsViewModel @Inject constructor(
    private val businessNewsUseCase: BusinessNewsUseCase,
    private val scienceNewsUseCase: ScienceNewsUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(CategoryNewsUiState())

    val scienceNewsUi: StateFlow<CategoryNewsUiState> = _uiState.asStateFlow()

    private var job: Job? = null

    fun loadCategoryNews(categoryName: String) {
        when(categoryName) {
            Constants.SCIENCE -> getScienceNews()
            Constants.BUSINESS -> getBusinessNews()
        }
    }

    private fun getScienceNews() {
        job?.cancel()
        job = viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when(val apiResult = scienceNewsUseCase.invoke()) {
                is ApiResult.Success<*> -> {
                    _uiState.update { it.copy(isLoading = false, newsList = apiResult.data as List<NewsUi>) }
                }
                is ApiResult.Error -> {
                    _uiState.update { it.copy(isLoading = false, errorMessage = apiResult.errorMessage) }
                }
            }
        }
    }

    private fun getBusinessNews() {
        job?.cancel()
        job = viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            when(val apiResult = businessNewsUseCase.invoke()) {
                is ApiResult.Success<*> -> {
                    _uiState.update { it.copy(isLoading = false, newsList = apiResult.data as List<NewsUi>) }
                }
                is ApiResult.Error -> {
                    _uiState.update { it.copy(isLoading = false, errorMessage = apiResult.errorMessage) }
                }
            }
        }
    }
}