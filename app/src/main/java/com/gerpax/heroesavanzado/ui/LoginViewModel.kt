package com.gerpax.heroesavanzado.ui

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.gerpax.heroesavanzado.data.Remote.LoginApi
import com.gerpax.heroesavanzado.ui.models.User
import com.squareup.moshi.Moshi
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.Exception

class LoginViewModel: ViewModel() {
    private var email: String = ""
    private var password: String = ""
    private lateinit var retrofit: Retrofit
    private lateinit var service: LoginApi
    private val  moshi: Moshi = TODO()
    private var token = ""

    fun createApiService() : LoginApi {
        retrofit =  Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(LoginApi::class.java)
    }

    fun ExecuteLogin(email: String, password: String) : String {
        service = createApiService()
        val call = service.login("login", email, password)

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful && response.body() != null) {
                    try {
                        val jsonUser = JSONObject(response.body()!!)
                        token = jsonUser.optString("token")
                        Log.d("token", token)
                    } catch (e: Exception) {
                        Log.d("Login", e.toString())
                    }
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("Login", t.toString())
            }
        })
        return token
    }
}