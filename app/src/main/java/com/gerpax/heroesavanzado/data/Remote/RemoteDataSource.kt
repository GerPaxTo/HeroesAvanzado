package com.gerpax.heroesavanzado.data.Remote

import com.gerpax.heroesavanzado.data.Remote.response.GetHerosResponse

interface RemoteDataSource {
    suspend fun getHeros(): List<GetHerosResponse>
}