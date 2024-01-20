package br.com.ale.testretrofit.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CustomRetrofit {
    private const val BASE_URL = "https://valorant-api.com/v1/"

    private val _retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofit = _retrofit
}