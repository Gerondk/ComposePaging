package com.gkp.composepaging.domain

import javax.inject.Inject

class GetBeerByIdUseCase @Inject constructor( private val beersRepository: BeersRepository) {
    suspend operator fun invoke(id: Int) = beersRepository.getBeerById(id)
}