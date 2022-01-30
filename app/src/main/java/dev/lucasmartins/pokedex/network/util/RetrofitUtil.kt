package dev.lucasmartins.pokedex.network.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {
    private fun getRetrofit(baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> getApiService(baseUrl: String, clazz: Class<T>): T = getRetrofit(baseUrl).create(clazz)
}