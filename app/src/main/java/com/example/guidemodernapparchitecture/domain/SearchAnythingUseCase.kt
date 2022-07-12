package com.example.guidemodernapparchitecture.domain

import com.example.guidemodernapparchitecture.data.repository.NewsRepository
import com.example.officedemo.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchAnythingUseCase @Inject constructor(
    private val repository: NewsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
){
    suspend operator fun invoke(searchKeyword: String) = withContext(defaultDispatcher){ repository.searchAnything(searchKeyword) }
}