package com.gkp.composepaging.data

data class DtoBeer(
    val abv: Double,
    val boil_volume: BoilVolume,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val first_brewed: String,
    val food_pairing: List<String>,
    val id: Int,
    val image_url: String,
    val ingredients: Ingredients,
    val name: String,
    val tagline: String,
    val volume: Volume
)