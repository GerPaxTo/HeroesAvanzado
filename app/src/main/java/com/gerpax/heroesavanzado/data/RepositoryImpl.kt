package com.gerpax.heroesavanzado.data

import com.gerpax.heroesavanzado.data.Remote.RemoteDataSource
import com.gerpax.heroesavanzado.data.local.LocalDataSource
import com.gerpax.heroesavanzado.data.mappers.LocalToPresentationMapper
import com.gerpax.heroesavanzado.data.mappers.RemoteToLocalMapper
import com.gerpax.heroesavanzado.ui.models.Hero
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToLocalMapper: RemoteToLocalMapper,

): Repository {

    override suspend fun getHeros(): List<Hero> {
        if (localDataSource.getHeros().isEmpty()) {
            val remoteSuperheros = remoteDataSource.getHeros()
            localDataSource.insertHeros(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheros))
        }
        return localToPresentationMapper.mapLocalSuperheros(localDataSource.getHeros())
    }
}