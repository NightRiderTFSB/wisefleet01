package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Usuario
import kotlinx.coroutines.*
import retrofit2.http.*

interface ApiUsuario {
    @GET("usuario")
    suspend fun getUsuarios(@Header("apikey") apiKey: String): List<Usuario>

    @GET("usuario")
    suspend fun getUsuario(@Query("idusuario") idusuario: String, @Query("apikey") apiKey: String): List<Usuario>

    @GET("usuario")
    suspend fun usuarioLogin(@Query("usuario") usuario: String, @Query("contrasena") contrasena: String, @Query("apikey") apiKey: String): List<Usuario>

    @POST("usuario")
    suspend fun createUsuario(@Body usuario: Usuario, @Header("apikey") apiKey: String): Usuario

    @PUT("usuario/{idUsuario}")
    suspend fun updateUsuario(@Path("idUsuario") idUsuario: Int, @Body usuario: Usuario, @Header("apikey") apiKey: String): Usuario

    @DELETE("usuario/{idUsuario}")
    suspend fun deleteUsuario(@Path("idUsuario") idUsuario: Int, @Header("apikey") apiKey: String)

}