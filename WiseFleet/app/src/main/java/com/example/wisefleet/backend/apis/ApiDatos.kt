package com.example.wisefleet.backend.apis

import com.example.wisefleet.backend.dataobjects.Datos
import retrofit2.http.*
interface ApiDatos {

    @GET("datos")
    suspend fun getDatos(@Header("apikey") apiKey: String): List<Datos>


}