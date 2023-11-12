package com.gkp.composepaging.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkp.composepaging.domain.Beer
import com.gkp.composepaging.domain.GetBeerByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transformLatest
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    getBeerByIdUseCase: GetBeerByIdUseCase,
    stateSavedStateHandle: SavedStateHandle
) : ViewModel() {


    val beer = stateSavedStateHandle.getStateFlow("id","").transformLatest { id ->
        if (id.isNotEmpty()) {
            val beer = getBeerByIdUseCase(id.toInt())
           emit(BeerState(beer = beer))
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, BeerState(isLoading = true))
}

data class BeerState( val isLoading: Boolean = false, val beer: Beer? = null)

