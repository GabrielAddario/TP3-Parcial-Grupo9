package com.example.appnectar.client

import com.example.appnectar.client.model.UserList
import com.example.appnectar.client.model.UserListItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET("users")
    suspend fun getUsers(): UserList

    @FormUrlEncoded
    @POST("users")
    fun createUser(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserListItem>

    @FormUrlEncoded
    @POST("auth/login")
    fun userLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<UserListItem>
}