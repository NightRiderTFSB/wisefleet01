package com.example.wisefleet.backend.dataobjects

import java.io.Serializable

data class Usuario(
    var idusuario: Int?,
    var usuario: String,
    var contrasena: String,
    var permiso: Boolean,
    var idempleadofk: Int
): Serializable{
    constructor(usuario: String, contrasena: String, permiso: Boolean, idempleadofk: Int)
            :this(null, usuario, contrasena, permiso, idempleadofk){

    }
}
