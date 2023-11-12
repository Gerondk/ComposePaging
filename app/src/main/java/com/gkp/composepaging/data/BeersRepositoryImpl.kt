package com.gkp.composepaging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gkp.composepaging.data.paging.BeersPagingSource
import com.gkp.composepaging.data.remote.BeerApi
import com.gkp.composepaging.domain.Beer
import com.gkp.composepaging.domain.BeersRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class BeersRepositoryImpl @Inject constructor(
    private  val beersPagingSource: BeersPagingSource,
    private  val beerApi: BeerApi
) : BeersRepository  {
    override fun getBeers() : Flow<PagingData<Beer>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            ),
            pagingSourceFactory = { beersPagingSource }
        ).flow

    }

    override suspend fun getBeerById(id: Int): Beer? {
        return try {
            beerApi.getBeerById(id).first().toBeer()
        } catch (e: Exception) {
            if(e is CancellationException) throw e
            null
        }

    }
}