package com.gkp.composepaging.data.paging

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gkp.composepaging.data.DtoBeer
import com.gkp.composepaging.data.remote.BeerApi
import com.gkp.composepaging.data.toBeer
import com.gkp.composepaging.domain.Beer
import java.io.IOException
import javax.inject.Inject


class BeersPagingSource @Inject constructor(private val beerApi: BeerApi) : PagingSource< Int, Beer>() {
    override fun getRefreshKey(state: PagingState<Int, Beer>): Int? {
        return  state.anchorPosition
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Beer> {
        val currentPage = params.key ?: 1

        return try {
            val beersList = beerApi.getBeers(currentPage,params.loadSize).map { it.toBeer() }
            Log.d("Beers", " current $currentPage count ${beersList.size} loadSize: ${params.loadSize}")
            LoadResult.Page(
                data = beersList,
                prevKey = if(currentPage == 1) null else currentPage -1,
                nextKey = if(beersList.isEmpty()) null else currentPage +1
            )

        } catch ( e : IOException) {
            LoadResult.Error(e)
        }catch (e : HttpException) {
            LoadResult.Error(e)
        }
    }

}