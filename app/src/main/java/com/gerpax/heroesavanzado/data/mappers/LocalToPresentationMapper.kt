package com.gerpax.heroesavanzado.data.mappers

import com.gerpax.heroesavanzado.data.local.model.LocalHero
import com.gerpax.heroesavanzado.ui.models.Hero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun mapLocalSuperheros(localSuperheros: List<LocalHero>): List<Hero> {
        return localSuperheros.map { mapLocalSuperheros(it) }
    }

    fun mapLocalSuperheros(getHerosResponse: LocalHero): Hero {
        return Hero(getHerosResponse.id, getHerosResponse.name, getHerosResponse.description, getHerosResponse.photo, getHerosResponse.favorite )
    }
}