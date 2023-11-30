package com.gkp.composepaging.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkp.composepaging.domain.Beer
import com.gkp.composepaging.domain.GetBeerByIdUseCase
import com.gkp.composepaging.util.BEER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transformLatest
import javax.inject.Inject

private  const val INVALID_BEER_ID = -1
@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    getBeerByIdUseCase: GetBeerByIdUseCase,
    stateSavedStateHandle: SavedStateHandle
) : ViewModel() {


    @OptIn(ExperimentalCoroutinesApi::class)
    val beerUiState = stateSavedStateHandle
        .getStateFlow(BEER_ID, INVALID_BEER_ID)
        .transformLatest { id ->
            if (id > 0) {
                val beer = getBeerByIdUseCase(id)
                emit(BeerState(beer = beer))
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            BeerState(isLoading = true)
        )
}

data class BeerState(
    val isLoading: Boolean = false,
    val beer: Beer? = null,
)

