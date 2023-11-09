package com.example.wisefleet.backend.dataobjects

data class Pedidos(
    var idpedido: Int?,
    var cliente: String,
    var telcliente: String,
    var descripcion: String,
    var total: Float,
    var entregado: Boolean,
    var cancelado: Boolean,
    var idempleadofk: Int
){
    constructor(cliente: String, telcliente: String, descripcion: String, total: Float, entregado: Boolean, cancelado: Boolean, idempleadofk: Int):
            this(null, cliente, telcliente, descripcion, total, entregado, cancelado, idempleadofk){

            }
}
