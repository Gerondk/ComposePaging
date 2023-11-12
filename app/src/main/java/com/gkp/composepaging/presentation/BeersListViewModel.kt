package com.gkp.composepaging.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gkp.composepaging.domain.GetBeersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeersListViewModel @Inject constructor( getBeersUseCase: GetBeersUseCase) : ViewModel() {

    val BeersPagingData = getBeersUseCase().cachedIn(viewModelScope)
}