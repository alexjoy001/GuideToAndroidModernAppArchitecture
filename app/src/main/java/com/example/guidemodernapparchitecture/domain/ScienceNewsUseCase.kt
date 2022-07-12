package com.example.guidemodernapparchitecture.domain

import com.example.guidemodernapparchitecture.data.repository.NewsRepository
import com.example.officedemo.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScienceNewsUseCase @Inject constructor(
    private val repository: NewsRepository,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke() = withContext(dispatcher) { repository.getScienceNews() }
}