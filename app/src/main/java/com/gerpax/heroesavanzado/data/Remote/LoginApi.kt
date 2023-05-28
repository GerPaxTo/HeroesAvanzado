package com.gerpax.heroesavanzado.data.Remote

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {
    @FormUrlEncoded
    @POST("api/auth/login")
    fun login(@Field("funcion") function: String,
              @Field("Username") Username: String,
              @Field("Password") Password: String
    ) : Call<String>
}