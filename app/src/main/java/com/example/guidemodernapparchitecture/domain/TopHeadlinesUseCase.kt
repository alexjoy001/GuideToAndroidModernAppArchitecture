package com.example.guidemodernapparchitecture.domain

import com.example.guidemodernapparchitecture.data.repository.NewsRepository
import com.example.guidemodernapparchitecture.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(country: String) = withContext(defaultDispatcher){ repository.topHeadLines(country) }
}