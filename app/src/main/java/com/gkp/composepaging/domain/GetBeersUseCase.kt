package com.gkp.composepaging.domain

import javax.inject.Inject

class GetBeersUseCase @Inject constructor(private  val beersRepository: BeersRepository) {

    operator fun invoke() = beersRepository.getBeers()
}