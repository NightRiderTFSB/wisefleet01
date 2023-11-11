package com.example.wisefleet.backend.dataobjects
data class Empleado(
    var idempleado: Int?,
    var nombre: String,
    var apellidop: String,
    var apellidom: String,
    var numleciencia: String,
    var telefono: String
) {
    constructor(nombre: String, apellidop: String, apellidom: String, numleciencia: String, telefono: String):
            this(null, nombre, apellidop, apellidom, numleciencia, telefono){

    }
}