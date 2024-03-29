package com.example.compose_introducao.api

import com.example.compose_introducao.api.request.LoginRequestBody
import com.example.compose_introducao.api.response.LoginResponseBody
import com.example.compose_introducao.api.response.UsuarioResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthEndPoint{

    @POST("/login")
    fun login(@Body requestBody: LoginRequestBody): Call<LoginResponseBody>

    @GET("/usuarios")
    suspend fun usuarios(): Response<UsuarioResponseBody>
}