package com.gerpax.heroesavanzado.data.local

import com.gerpax.heroesavanzado.data.local.model.LocalHero

interface LocalDataSource {
        suspend fun getHeros(): List<LocalHero>

        suspend fun insertHero(localSuperhero: LocalHero)

        suspend fun insertHeros(localSuperheros: List<LocalHero>)
}