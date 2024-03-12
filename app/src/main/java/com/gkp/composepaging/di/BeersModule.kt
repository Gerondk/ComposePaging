package com.gkp.composepaging.di

import com.gkp.composepaging.data.BeersRepositoryImpl
import com.gkp.composepaging.data.paging.BeersPagingSource
import com.gkp.composepaging.data.remote.BeerApi
import com.gkp.composepaging.domain.BeersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BeersModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BeerApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Singleton
    @Provides
    fun providesBeersApi(retrofit: Retrofit): BeerApi = retrofit.create(BeerApi::class.java)

    @Singleton
    @Provides
    fun providesBeersRepository(beersPagingSource: BeersPagingSource, beerApi: BeerApi ): BeersRepository {
        return BeersRepositoryImpl(beersPagingSource,beerApi)
    }
}