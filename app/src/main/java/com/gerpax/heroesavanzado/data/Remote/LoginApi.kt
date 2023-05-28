package com.gerpax.heroesavanzado.data.Remote

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApi {
    @FormUrlEncoded
    @POST("api/auth/login")
    fun login(@Field("login") function: String,
              @Header("Authorization") header: String
    ) : Call<String>
}