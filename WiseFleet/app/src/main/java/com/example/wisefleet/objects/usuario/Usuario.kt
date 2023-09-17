package com.example.wisefleet.objects.usuario

class Usuario() {

    public var idUsuario:Int = 0; //Declaracion publica para usarlos mas facilmente en las demas clases
    public var usuario:String = "";
    public var contrasena:String = "";
    public var permiso:Boolean = false;
    public var idEmpleadoFK:Int = 0;

    constructor(idUsuario:Int, usuario:String, contrasena:String, permiso:Boolean, idEmpleadoFK:Int):this(){
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.permiso = permiso;
        this.idEmpleadoFK = idEmpleadoFK;
    }



}