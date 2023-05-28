package com.gerpax.heroesavanzado.di

import com.gerpax.heroesavanzado.data.Remote.RemoteDataSource
import com.gerpax.heroesavanzado.data.Remote.RemoteDataSourceImpl
import com.gerpax.heroesavanzado.data.Repository
import com.gerpax.heroesavanzado.data.RepositoryImpl
import com.gerpax.heroesavanzado.data.local.LocalDataSource
import com.gerpax.heroesavanzado.data.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}