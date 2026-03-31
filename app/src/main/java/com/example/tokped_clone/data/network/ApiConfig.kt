package com.example.tokped_clone.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    // Logging interceptor
    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}