package com.gkp.composepaging.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun BeersListScreen(onNavigateToDetail: (Int) -> Unit) {
    val viewModel = hiltViewModel<BeersListViewModel>()
    val listPaging  = viewModel.BeersPagingData.collectAsLazyPagingItems()

    if ( listPaging.loadState.refresh is LoadState.Loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
          CircularProgressIndicator(Modifier.size(50.dp))
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(listPaging.itemCount) { index ->
                val beer = listPaging[index]
                beer?.let {
                    BeerItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onNavigateToDetail(beer.id)
                            },
                        beer = it
                    )
                }
            }
            if (listPaging.loadState.append is LoadState.Loading) {
                item {
                    CircularProgressIndicator(Modifier.size(50.dp))
                }
            }
        }
    }




}