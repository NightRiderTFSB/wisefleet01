package com.example.wisefleet.backend.dataobjects

data class Usuario(
    var idusuario: Int?,
    var usuario: String,
    var contrasena: String,
    var permiso: Boolean,
    var idempleadofk: Int
){
    constructor(usuario: String, contrasena: String, permiso: Boolean, idempleadofk: Int)
            :this(null, usuario, contrasena, permiso, idempleadofk){

    }
}
