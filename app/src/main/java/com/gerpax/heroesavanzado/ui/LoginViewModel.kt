package com.gerpax.heroesavanzado.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gerpax.heroesavanzado.data.Remote.LoginApi
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import kotlin.io.encoding.ExperimentalEncodingApi

class LoginViewModel: ViewModel() {
    private lateinit var retrofit: Retrofit
    private lateinit var service: LoginApi

    fun createApiService() : LoginApi {
        retrofit =  Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        return retrofit.create(LoginApi::class.java)
    }

    @OptIn(ExperimentalEncodingApi::class)
    fun executeLogin(email: String, password: String): String {
        var token = ""
        service = createApiService()

        val credentials = Credentials.basic("$email", "$password")
        val call = service.login("login", "$credentials")

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful && response.body() != null) {
                    try {
                        token = response.body().toString()

                    } catch (e: Exception) {
                        Log.d("Login", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("Login $t.toString()")
            }
        })
       return token
    }
}