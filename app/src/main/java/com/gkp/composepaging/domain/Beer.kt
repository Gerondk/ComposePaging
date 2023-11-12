package com.gkp.composepaging.domain

data class Beer(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val tagLine: String,
    val firstBrewed: String
)
