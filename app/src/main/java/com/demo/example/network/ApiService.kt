package com.demo.example.network

import com.demo.example.model.RegisterRequest
import com.demo.example.model.RegisterResult
import com.demo.example.model.User
import com.demo.example.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

import retrofit2.Callback;
import retrofit2.http.Headers
import retrofit2.Call

interface ApiService {
    @GET("/")
    suspend fun getUserResponse(): UserResponse

//    @Headers("Content-Type: application/json")
//    @POST("api/register")
//    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResult>

    @Headers("Content-Type: application/json")
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): Call<RegisterResult>

//    @POST("/register")
//    fun registerUser(@Body user: RegisterRequest, registerCallback: Callback<RegisterResult?>?)

}
