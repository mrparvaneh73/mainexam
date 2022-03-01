package com.example.mainexam

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ProfileService {
    @GET("users")
    fun getuser(): Call<List<User>>

    @Multipart
    @POST("users/{id}/image")
    fun sendImage(
        @Path("id") id: String,
        @Part image: MultipartBody.Part
    ): Call<Any>
    @POST("users")
    fun sendaccount(
        @Body body: User
    ): Call<String>
}