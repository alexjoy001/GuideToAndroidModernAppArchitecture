package com.example.guidemodernapparchitecture.ui.searchanynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.example.guidemodernapparchitecture.common.DisplayNewsItem
import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchAnyNewsActivity : ComponentActivity() {

    private val viewModel: SearchAnythingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                AppBar()
                HomePageContent()
            }

        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        Column() {
            AppBar()
            HomePageContent()
        }
    }

    @Composable
    fun AppBar() {
        TopAppBar(title = { Text(text = "Guide to App Architecture") })
    }

    @Composable
    fun HomePageContent() {
        var searchKeyWord by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = searchKeyWord, onValueChange = {
                searchKeyWord = it
            })
            Button(onClick = { viewModel.search(searchKeyWord) }) {
                Text(text = "Search")
            }
            DisplayNews()
        }
    }



    @Composable
    fun DisplayNews() {
        val isLoading = viewModel.searchAnythingUI.collectAsState().value.isLoading
        val newsList = viewModel.searchAnythingUI.collectAsState().value.newsList
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
                    DisplayNewsItem(newsList[index])
                }
            }
        }
    }


}