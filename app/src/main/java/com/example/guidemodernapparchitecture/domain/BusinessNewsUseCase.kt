package com.example.guidemodernapparchitecture.domain

import com.example.guidemodernapparchitecture.data.repository.NewsRepository
import com.example.guidemodernapparchitecture.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BusinessNewsUseCase @Inject constructor(
    private val repository: NewsRepository,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() = withContext(dispatcher) { repository.getCategoryNews("business") }
}