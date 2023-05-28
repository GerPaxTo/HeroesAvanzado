package com.gerpax.heroesavanzado.data.Remote

import com.gerpax.heroesavanzado.data.Remote.request.GetHerosRequestBody
import com.gerpax.heroesavanzado.data.Remote.response.GetHerosResponse
import com.gerpax.heroesavanzado.ui.models.Hero
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

const val TOKEN = "eyJraWQiOiJwcml2YXRlIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJpZGVudGlmeSI6IjdBQjhBQzRELUFEOEYtNEFDRS1BQTQ1LTIxRTg0QUU4QkJFNyIsImV4cGlyYXRpb24iOjY0MDkyMjExMjAwLCJlbWFpbCI6ImJlamxAa2VlcGNvZGluZy5lcyJ9.QIejrDM8QNqo6cuJqjNR1qoS3VqgBKiVvp6uy9JkV-c"

interface DragonBallApi {

    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeros(@Body getHerosRequestBody: GetHerosRequestBody): List<GetHerosResponse>

}