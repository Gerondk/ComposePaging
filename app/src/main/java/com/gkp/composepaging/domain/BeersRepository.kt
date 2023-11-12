package com.gkp.composepaging.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface BeersRepository {
    fun getBeers(): Flow<PagingData<Beer>>
    suspend fun  getBeerById( id: Int): Beer?
}