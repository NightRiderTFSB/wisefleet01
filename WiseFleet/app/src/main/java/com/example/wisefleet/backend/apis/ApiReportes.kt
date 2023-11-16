package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Reportes
import kotlinx.coroutines.*
import retrofit2.http.*

interface ApiReportes {

    @GET("reportes")
    suspend fun getReportes(@Header("apikey") apiKey: String): List<Reportes>

    @GET("reportes")
    suspend fun getReporte(@Query("idreporte") idreporte: String, @Query("apikey") apiKey: String): List<Reportes>

    @POST("reportes")
    suspend fun createReporte(@Body reporte: Reportes, @Header("apikey") apiKey: String): Reportes

    @PUT("reportes/{idreporte}")
    suspend fun updateReporte(@Path("idreporte") idpedido: Int, @Body reporte: Reportes, @Header("apikey") apiKey: String): Reportes

    @DELETE("reportes/{idreporte}")
    suspend fun deleteReporte(@Path("idreporte") idUsuario: String, @Header("apikey") apiKey: String)

}