package com.gerpax.heroesavanzado.data

import com.gerpax.heroesavanzado.data.Remote.RemoteDataSource
import com.gerpax.heroesavanzado.ui.models.Hero

interface Repository {

    suspend fun getHeros(): List<Hero>

}