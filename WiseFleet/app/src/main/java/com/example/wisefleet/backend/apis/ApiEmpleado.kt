package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Empleado

import kotlinx.coroutines.*
import retrofit2.http.*

interface ApiEmpleado {
    @GET("empleado")
    suspend fun getEmpleados(@Header("apikey") apiKey: String): List<Empleado>

    @GET("empleado")
    suspend fun getEmpleado(@Query("idempleado") idempleado: String, @Query("apikey") apiKey: String): List<Empleado>

    @POST("empleado")
    suspend fun createEmpleado(@Body empleado: Empleado, @Header("apikey") apiKey: String): Empleado

    @PUT("empleado/{idempleado}")
    suspend fun updateEmpleado(@Path("idempleado") idempleado: Int, @Body empleado: Empleado, @Header("apikey") apiKey: String): Empleado

    @DELETE("empleado/{idempleado}")
    suspend fun deleteEmpleado(@Path("idempleado") idempleado: Int, @Header("apikey") apiKey: String)
}