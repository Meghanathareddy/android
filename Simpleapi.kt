package com.example.splashscreen.api

import com.example.splashscreen.model.Json4Kotlin_Base
import com.example.splashscreen.model.LoginRequest
import com.example.splashscreen.model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface Simpleapi {
    @GET("posts")
    suspend fun getCustomPost(
        @Query("id") id:Int
    ):Response<Json4Kotlin_Base>

    @POST("/api/login")
    suspend fun login(
        @Body request: LoginRequest
    ):Response<LoginResponse>
}