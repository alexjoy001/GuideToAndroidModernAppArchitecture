package com.example.guidemodernapparchitecture.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guidemodernapparchitecture.ui.models.NewsUi
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DisplayNewsItem(newsUi: NewsUi, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        onClick =  {
            onClick.invoke()
        }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            newsUi.urlToImage?.let { GlideImage(
                imageModel = it,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(350.dp)
            ) }
            newsUi.title?.let { Text(text = it, fontWeight = FontWeight.Bold, fontSize = 20.sp) }
            newsUi.description?.let { Text(text = it) }
            newsUi.author?.let { Text(text = it, fontWeight = FontWeight.Bold, fontSize = 13.sp) }
        }
    }
}