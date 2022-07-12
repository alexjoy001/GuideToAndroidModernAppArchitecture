package com.example.guidemodernapparchitecture

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.guidemodernapparchitecture.ui.businessnews.BusinessNewsActivity
import com.example.guidemodernapparchitecture.ui.sciencenews.ScienceNewsActivity
import com.example.guidemodernapparchitecture.ui.searchanynews.SearchAnyNewsActivity
import com.example.guidemodernapparchitecture.ui.topheadlines.TopHeadlinesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppBar()
            ButtonList()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AppBar()
        ButtonList()
    }

    @Composable
    fun AppBar() {
        TopAppBar(title = { Text(text = "Guide to App Architecture") })
    }

    @Composable
    fun ButtonList() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                val intent = Intent(this@MainActivity, SearchAnyNewsActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Search any news")
            }
            Button(onClick = {
                startActivity(Intent(this@MainActivity, TopHeadlinesActivity::class.java))
            }) {
                Text(text = "Top HeadLines")
            }
            Button(onClick = {
                startActivity(Intent(this@MainActivity, BusinessNewsActivity::class.java))
            }) {
                Text(text = "Business")
            }
            Button(onClick = {
                startActivity(Intent(this@MainActivity, ScienceNewsActivity::class.java))
            }) {
                Text(text = "Science")
            }
        }
    }
}

