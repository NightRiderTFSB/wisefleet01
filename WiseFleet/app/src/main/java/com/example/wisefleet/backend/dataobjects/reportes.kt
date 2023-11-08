package com.example.wisefleet.backend.dataobjects

data class reportes(
    var idreporte: Int?,
    var descripcion: String,
    var idvehiculofk: Int,
    var idempleadofk: Int
){
    constructor(descripcion: String, idvehiculofk: Int, idempleadofk: Int):
            this(null, descripcion, idvehiculofk, idempleadofk){

            }
}
