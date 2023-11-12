package com.gkp.composepaging.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun BeerDetailScreen() {
    val viewModel = hiltViewModel<BeerDetailViewModel>()
    val beersState by viewModel.beer.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        beersState.beer?.let {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    AsyncImage(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        model = it.imageUrl,
                        contentDescription = ""
                    )
                }
                item {
                    Text(text = it.name, style = MaterialTheme.typography.headlineSmall)
                }
                item {
                    Text(text = it.tagLine, fontStyle = FontStyle.Italic)
                }
                item {
                    Text(text = it.description)
                }
                item {
                    Text(text = it.firstBrewed)
                }
            }
        } ?: Text(
            text = "Network error occurs",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.headlineMedium
        )
    }

}