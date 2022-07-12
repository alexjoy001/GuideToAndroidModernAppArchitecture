package com.example.guidemodernapparchitecture.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guidemodernapparchitecture.models.apiresponsemodels.NewsApiResponse
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DisplayNewsItem(newsApiResponse: NewsApiResponse) {
    Card(
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            newsApiResponse.urlToImage?.let { GlideImage(
                imageModel = it,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(350.dp)
            ) }
            newsApiResponse.title?.let { Text(text = it, fontWeight = FontWeight.Bold, fontSize = 20.sp) }
            newsApiResponse.description?.let { Text(text = it) }
            newsApiResponse.author?.let { Text(text = it, fontWeight = FontWeight.Bold, fontSize = 13.sp) }
        }
    }
}