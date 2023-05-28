package com.gerpax.heroesavanzado.data.local

import com.gerpax.heroesavanzado.data.local.model.LocalHero
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: SuperheroDAO): LocalDataSource {

    override suspend fun getHeros(): List<LocalHero>{
        return dao.getAll()
    }

    override suspend fun insertHero(localSuperhero: LocalHero){
        dao.insertAllList(listOf(localSuperhero))
    }

    override suspend fun insertHeros(localSuperheros: List<LocalHero>){
        dao.insertAllList(localSuperheros)
    }

}