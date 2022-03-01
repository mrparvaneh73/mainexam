package com.example.mainexam

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(AuthenticationInterceptor()).addInterceptor(
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://papp.ir/api/v1/")

        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val service:ProfileService = retrofit.create(ProfileService::class.java)
}