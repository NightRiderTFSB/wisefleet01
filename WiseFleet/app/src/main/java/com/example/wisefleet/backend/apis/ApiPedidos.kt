package com.example.wisefleet.backend.apis


import com.example.wisefleet.backend.dataobjects.Pedidos
import kotlinx.coroutines.*
import retrofit2.http.*

interface ApiPedidos {

    @GET("pedidos")
    suspend fun getPedidos(@Header("apikey") apiKey: String): List<Pedidos>

    @GET("pedidos")
    suspend fun getPedido(@Query("idpedido") idusuario: String, @Query("apikey") apiKey: String): List<Pedidos>

    @GET("pedidos")
    suspend fun getPedidosUsuario(@Query("idempleadofk") idempleadofk: String, @Query("apikey") apikey: String): List<Pedidos>

    @POST("pedidos")
    suspend fun createPedido(@Body pedido: Pedidos, @Header("apikey") apiKey: String): Pedidos

    @PUT("pedidos/{idpedido}")
    suspend fun updatePedido(@Path("idpedido") idpedido: Int, @Body pedido: Pedidos, @Header("apikey") apiKey: String): Pedidos

    @DELETE("pedidos/{idpedido}")
    suspend fun deletePedido(@Path("idpedido") idUsuario: Int, @Header("apikey") apiKey: String)

}