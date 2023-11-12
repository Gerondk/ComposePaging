package com.gkp.composepaging.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gkp.composepaging.domain.Beer

@Composable
fun BeerItem(
    modifier: Modifier,
    beer: Beer,
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.weight(1f).size(150.dp),
                model = beer.imageUrl,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(3f)) {
                Text(text = beer.name, style =  MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = beer.tagLine, fontStyle = FontStyle.Italic, color = Color.LightGray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = beer.description,)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = beer.firstBrewed, fontSize = 8.sp)
            }
        }
    }

}