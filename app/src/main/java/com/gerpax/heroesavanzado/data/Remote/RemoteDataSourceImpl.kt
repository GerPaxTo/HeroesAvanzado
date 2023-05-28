package com.gerpax.heroesavanzado.data.Remote

import com.gerpax.heroesavanzado.data.Remote.request.GetHerosRequestBody
import com.gerpax.heroesavanzado.data.Remote.response.GetHerosResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: DragonBallApi): RemoteDataSource {

    override suspend fun getHeros(): List<GetHerosResponse> {
        return api.getHeros(GetHerosRequestBody())
    }
}