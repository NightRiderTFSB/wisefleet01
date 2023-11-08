package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Usuario
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiUsuario {
    @GET("usuario")
    suspend fun getUsuarios(@Header("apikey") apiKey: String): List<Usuario>

    @GET("usuario/{idUsuario}")
    suspend fun getUsuario(@Path("idUsuario") idUsuario: Int, @Header("apikey") apiKey: String): Usuario

    @POST("usuario")
    suspend fun createUsuario(@Body usuario: Usuario, @Header("apikey") apiKey: String): Usuario

    @PUT("usuario/{idUsuario}")
    suspend fun updateUsuario(@Path("idUsuario") idUsuario: Int, @Body usuario: Usuario, @Header("apikey") apiKey: String): Usuario

    @DELETE("usuario/{idUsuario}")
    suspend fun deleteUsuario(@Path("idUsuario") idUsuario: Int, @Header("apikey") apiKey: String)

    /*suspend fun construirApi(): ApiUsuario{
        val baseUrl = ""

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val usuariosApi = retrofit.create(ApiUsuario::class.java)
        return usuariosApi
    }*/
}