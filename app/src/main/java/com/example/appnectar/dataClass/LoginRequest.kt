package com.example.appnectar.dataClass

import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)

interface ApiService {
    @POST("auth/login")
    suspend fun loginUser(@Body request: LoginRequest): LoginResponse
}

