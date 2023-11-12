package com.gkp.composepaging.data

import com.gkp.composepaging.domain.Beer

fun DtoBeer.toBeer()=
    Beer(
        id = id,
        name = name,
        description = description,
        imageUrl = image_url,
        tagLine = tagline,
        firstBrewed = first_brewed
    )