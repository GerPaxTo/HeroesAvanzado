package com.gerpax.heroesavanzado.data.mappers

import com.gerpax.heroesavanzado.data.Remote.response.GetHerosResponse
import com.gerpax.heroesavanzado.data.local.model.LocalHero
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(getHerosResponses: List<GetHerosResponse>): List<LocalHero> {
        return getHerosResponses.map { mapGetHeroResponse(it) }
    }

    fun mapGetHeroResponse(getHerosResponse: GetHerosResponse): LocalHero {
        return LocalHero(getHerosResponse.id, getHerosResponse.name, getHerosResponse.description, getHerosResponse.photo, getHerosResponse.favorite)
    }
}