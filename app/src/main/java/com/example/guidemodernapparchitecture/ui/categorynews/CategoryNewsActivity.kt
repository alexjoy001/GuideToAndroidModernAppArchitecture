package com.example.guidemodernapparchitecture.ui.categorynews

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guidemodernapparchitecture.ui.common.DisplayNewsItem
import com.example.guidemodernapparchitecture.ui.newsdetail.NewsDetailActivity
import com.example.guidemodernapparchitecture.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryNewsActivity : ComponentActivity() {

    private val viewModel: CategoryNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras?.getString(Constants.CATEGORY)?.let {
            viewModel.loadCategoryNews(it)
        }

        setContent {
            Column {
                AppBar()
                DisplayNews()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Column {
            AppBar()
            DisplayNews()
        }
    }

    @Composable
    fun AppBar() {
        TopAppBar(title = { Text(text = "Guide to Modern Architecture") })
    }

    @Composable
    fun DisplayNews() {
        val isLoading = viewModel.scienceNewsUi.collectAsState().value.isLoading
        val newsList = viewModel.scienceNewsUi.collectAsState().value.newsList
        if (isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(newsList.size) { index ->
                    DisplayNewsItem(newsList[index], onClick = {
                        val intent = Intent(this@CategoryNewsActivity, NewsDetailActivity::class.java)
                        intent.putExtra(Constants.NEWS, newsList[index])
                        startActivity(intent)
                    })
                }
            }
        }
    }
}