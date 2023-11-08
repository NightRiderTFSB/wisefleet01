package com.example.wisefleet.backend.dataobjects

data class Estadisticas(
    var idestadistica: Int?,
    var celcius: Float,
    var ubicacion: String,
    var idvehiculofk: Int
){
    constructor(celcius: Float, ubicacion: String, idvehiculofk: Int):
            this(null, celcius, ubicacion, idvehiculofk){

            }
}
