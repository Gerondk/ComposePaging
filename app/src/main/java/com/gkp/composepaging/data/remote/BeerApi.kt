package com.gkp.composepaging.data.remote

import com.gkp.composepaging.data.DtoBeer
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BeerApi {
    @GET("beers")
    suspend fun  getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int,
    ): List<DtoBeer>

    @GET("beers/{id}")
    suspend fun getBeerById(@Path("id") id: Int): List<DtoBeer>

    companion object {
        const val  BASE_URL = "https://api.punkapi.com/v2/"
    }
}