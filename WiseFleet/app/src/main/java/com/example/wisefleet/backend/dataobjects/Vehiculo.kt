package com.example.wisefleet.backend.dataobjects

data class Vehiculo(
    var idvehiculo: Int?,
    var modelo: String,
    var ano: String,
    var color: String,
    var placas: String,
    var numtarjeta: String,
    var rendimientokmslt: Float,
    var disponible: Boolean
){
    constructor(modelo: String, ano: String, color: String, placas: String, numtarjeta: String, rendimientokmslt: Float, disponible: Boolean):
            this(null, modelo, ano, color, placas, numtarjeta, rendimientokmslt, disponible){

            }
}
