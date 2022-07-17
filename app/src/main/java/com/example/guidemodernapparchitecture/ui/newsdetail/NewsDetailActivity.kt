package com.example.guidemodernapparchitecture.ui.newsdetail

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import com.example.guidemodernapparchitecture.util.Constants
import com.skydoves.landscapist.glide.GlideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailActivity : ComponentActivity() {

    private val viewModel: NewsDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras?.getParcelable<NewsUi>(Constants.NEWS)?.let {
            Log.d("GETTT ", it.source?.name.toString())
            viewModel.setNewsDetail(it)
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
        TopAppBar(title = { Text(text = "Guide to Modern Architecture")})
    }
    
    @Composable
    fun DisplayNews() {
        Column {
            viewModel.newsDetailUi.collectAsState().value.let {
                it.title?.let { title -> Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp) }
                Spacer(modifier = Modifier.height(10.dp))
                it.urlToImage?.let { urlToImage -> GlideImage(
                    imageModel = urlToImage,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                ) }
                Spacer(modifier = Modifier.height(10.dp))
                it.content?.let { content -> Text(text = content) }
                Spacer(modifier = Modifier.height(10.dp))
                it.description?.let { description -> Text(text = description, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp) }
                Spacer(modifier = Modifier.height(10.dp))
                it.author?.let { author -> Text(text = "Author -$author", fontWeight = FontWeight.Bold, fontSize = 13.sp) }
                Spacer(modifier = Modifier.height(10.dp))
                it.url?.let { url -> Text(text = "Source url -> $url", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp) }
                Spacer(modifier = Modifier.height(10.dp))
                it.source?.let { source -> Text(text = "Source Page -> ${source.name}", fontWeight = FontWeight.ExtraBold, fontSize = 15.sp) }
            }
        }
    }

}