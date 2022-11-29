package com.farooq.rss.ui_stories.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farooq.rss.domain.model.Story

@Composable
fun StoryListItem(story: Story, modifier: Modifier = Modifier, onItemClick: (Story) -> Unit) {
    val typography = MaterialTheme.typography
    Card(modifier = modifier.clickable { onItemClick(story) }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val imageModifier = Modifier
                .heightIn(min = 150.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)
            Image(
                painter = rememberAsyncImagePainter(story.image),
                contentDescription = null, // decorative
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = story.title,
                style = typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = story.description,
                style = typography.labelMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}