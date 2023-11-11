package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Vehiculo
import retrofit2.http.*

interface ApiVehiculo {

    @GET("vehiculo")
    suspend fun getVehiculos(@Header("apikey") apiKey: String): List<Vehiculo>

    @GET("vehiculo")
    suspend fun getVehiculo(@Query("idvehiculo") idvehiculo: String, @Query("apikey") apiKey: String): List<Vehiculo>

    @POST("vehiculo")
    suspend fun createVehiculo(@Body vehiculo: Vehiculo, @Header("apikey") apiKey: String): Vehiculo

    @PUT("vehiculo/{idvehiculo}")
    suspend fun updateVehiculo(@Path("idvehiculo") idvehiculo: Int, @Body vehiculo: Vehiculo, @Header("apikey") apiKey: String): Vehiculo

    @DELETE("vehiculo/{idvehiculo}")
    suspend fun deleteVehiculo(@Path("idvehiculo") idvehiculo: Int, @Header("apikey") apiKey: String)

}