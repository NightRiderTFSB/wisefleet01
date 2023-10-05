package com.example.wisefleet.objects.empleado;
import com.example.wisefleet.ConexionSQL;

import java.lang.Exception
import java.sql.CallableStatement

class Empleado() {

    //Declaracion publica para usarlos mas facilmente en las demas clases
    public var idEmpleado:Int = 0;
    public var nombre:String = "";
    public var apellidoP:String = "";
    public var apellidoM:String = "";
    public var numLicencia:String = "";
    public var telefono:String = "";

    //Declaracion de constructor con todos los parametros
    constructor(idEmpleado:Int, nombre:String, apellidoP:String, apellidoM:String, numLicencia:String, telefono:String): this(){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.numLicencia = numLicencia;
        this.telefono = telefono;
    }

    //Procedimiento almacenado para agregar empleado a la BD
    fun stp_empleado_add(empleado: Empleado): Boolean{ //Devuelve boolean para saber si agregó o no
        try{
            val conexion = ConexionSQL().getConexion() //Obtenemos nuestro enlace a la BD
            var addstmt: CallableStatement = conexion!!.prepareCall("{CALL stp_add_empleado(?, ?, ?, ?, ?)}"); // preparamos nuestro procedimiento almacenado
            addstmt.setString(1, empleado.nombre);
            addstmt.setString(2, empleado.apellidoP);
            addstmt.setString(3, empleado.apellidoM);
            addstmt.setString(4, empleado.numLicencia);
            addstmt.setString(5, empleado.telefono);
            addstmt.execute();
            conexion.close();
            return true;
        }catch (e: Exception){
            println("HA OCURRIDO UN ERROR AL AGREGAR EMPLEADO")
            e.printStackTrace();
            return false;
        }
    }

    //Procedimiento almacenado para remover empleado de la BD
    fun stp_remove_empleado(empleado: Empleado): Boolean{
        try{
            val conexion = ConexionSQL().getConexion() //Obtenemos nuestro enlace a la BD
            var removestmt: CallableStatement = conexion!!.prepareCall("{CALL stp_remove_empleado(?)}"); // preparamos nuestro procedimiento almacenado
            removestmt.setInt(1, empleado.idEmpleado);
            removestmt.execute();
            conexion.close();
            return true;
        }catch (e: Exception){
            println("HA OCURRIDO UN ERROR AL ELIMINAR EMPLEADO");
            e.printStackTrace();
            return false;
        }
    }

    //Procedimiento almacenado para actualizar empleado
    fun stp_update_empleado(empleado: Empleado): Boolean{
        try{
            val conexion = ConexionSQL().getConexion() //Obtenemos nuestro enlace a la BD
            var updatestmt: CallableStatement = conexion!!.prepareCall("{CALL stp_update_empleado(?, ?, ?, ?, ?, ?)}"); // preparamos nuestro procedimiento almacenado
            updatestmt.setString(1, empleado.nombre);
            updatestmt.setString(2, empleado.apellidoP);
            updatestmt.setString(3, empleado.apellidoM);
            updatestmt.setString(4, empleado.numLicencia);
            updatestmt.setString(5, empleado.telefono);
            updatestmt.setInt(6, empleado.idEmpleado);
            updatestmt.execute();
            conexion.close();
            return true;
        }catch (e: Exception){
            println("HA OCURRIDO UN ERROR AL ACTUALIZAR EMPLEADO");
            e.printStackTrace();
            return false;
        }
    }

    //Procedimiento almacenado para buscar empleado por ID
    fun stp_lookByID_empleado(empleado: Empleado): Empleado{
        try{
            val conexion = ConexionSQL().getConexion(); //Obtenemos nuestro enlace a la BD
            var lookbyidStmt: CallableStatement = conexion!!.prepareCall("{CALL stp_lookByID_empleado(?)}");
            lookbyidStmt.setInt(1, empleado.idEmpleado);
            lookbyidStmt.execute();
            conexion.close();
            return  Empleado(lookbyidStmt.getInt(1), lookbyidStmt.getString(2), lookbyidStmt.getString(3), lookbyidStmt.getString(4),
                                lookbyidStmt.getString(5), lookbyidStmt.getString(6)) //Return de empleado con los atributos
        }catch (e: Exception){
            println("HA OCURRIDO UN ERROR AL ACTUALIZAR EMPLEADO");
            e.printStackTrace();
            return Empleado(); //return de empleado vacío
        }
    }

    //Procedimiento almacenado para buscar empleado por licencia
    fun stp_lookByLicencia_empleado(empleado: Empleado): Empleado{
        try{
            val conexion = ConexionSQL().getConexion() //Obtenemos nuestro enlace a la BD
            var lookbylicenciaStmt: CallableStatement = conexion!!.prepareCall("{CALL stp_lookByNumLicencia_empleado(?)}");
            lookbylicenciaStmt.setString(1, empleado.numLicencia);
            lookbylicenciaStmt.execute();
            conexion.close();
            return Empleado(lookbylicenciaStmt.getInt(1), lookbylicenciaStmt.getString(2), lookbylicenciaStmt.getString(3), lookbylicenciaStmt.getString(4),
                lookbylicenciaStmt.getString(5), lookbylicenciaStmt.getString(6)) //Return de empleado con los atributos
        }catch (e: Exception){
            println("HA OCURRIDO UN ERROR AL ACTUALIZAR EMPLEADO");
            e.printStackTrace();
            return Empleado(); //return de empleado vacío
        }
    }

    fun stp_lookByTelefono_empleado(empleado: Empleado): Empleado {
        try {
            val conexion = ConexionSQL().getConexion() //Obtenemos nuestro enlace a la BD
            var lookbytelefonoStmt: CallableStatement =
                conexion!!.prepareCall("{CALL stp_lookByTelefono_empleado(?)}")
            lookbytelefonoStmt.setString(1, empleado.telefono);
            lookbytelefonoStmt.execute();
            conexion.close();

        } catch (e: Exception) {
        }
        return Empleado();
    }
}