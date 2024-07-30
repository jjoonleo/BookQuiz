package com.example.bookquiz.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bookquiz.R

@Composable
fun BookListItem()

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageListItem(name: String, imageUrl: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.card_side_margin))
            .padding(bottom = dimensionResource(id = R.dimen.card_bottom_margin))
    ) {
        Column(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.book_item_image_width))
        ) {
            GlideImage(
                model = imageUrl,
                contentDescription = "List item image",
                Modifier
                    .width(dimensionResource(id = R.dimen.book_item_image_width))
                    .height(dimensionResource(id = R.dimen.book_item_image_height))
                    .clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name,
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageListItemPreview() {
    ImageListItem(
        name = "test",
        imageUrl = "https://bookquiz.co.kr/quizbank/bookimg/%EC%98%A4%EB%8A%98%EB%B6%80%ED%84%B0%EB%B2%A0%ED%94%84%EB%B2%A0%ED%94%84.jpg",
        onClick = {}
    )
}