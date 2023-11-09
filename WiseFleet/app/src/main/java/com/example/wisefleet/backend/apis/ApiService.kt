package com.example.wisefleet.backend.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    public val apiKey:  String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV1dW94bHhlbWdlcHpzd2RxbmVxIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTk0MjE4MTAsImV4cCI6MjAxNDk5NzgxMH0.B7UOAhAuXpek_uA632jxZ3cAUW52aiYKtHeNlMwC034";

    suspend fun conectarApiUsuario(): ApiUsuario{
        val baseUrl = "https://uuuoxlxemgepzswdqneq.supabase.co/rest/v1/" // Reemplaza esto con la URL base de tu API de Supabase

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiUsuario = retrofit.create(ApiUsuario::class.java)
        return apiUsuario
    }

    suspend fun conectarApiEmpleado(): ApiEmpleado{
        val baseUrl = "https://uuuoxlxemgepzswdqneq.supabase.co/rest/v1/" // Reemplaza esto con la URL base de tu API de Supabase

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiEmpleado = retrofit.create(ApiEmpleado::class.java)
        return apiEmpleado
    }

    suspend fun conectarApiVehiculo(): ApiVehiculo{
        val baseUrl = "https://uuuoxlxemgepzswdqneq.supabase.co/rest/v1/" // Reemplaza esto con la URL base de tu API de Supabase

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiVehiculo = retrofit.create(ApiVehiculo::class.java)
        return apiVehiculo
    }




}