package com.example.wisefleet
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexionSQL {

    fun getConexion(): Connection?{ //Si no se realiza la conexion devolverá null, ideal el uso del if
        val url = "jdbc:mysql//localhost:3306/wisefleetdb";
        val usuario = "";
        val constrasena = "";

        return try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url, usuario, constrasena)
        }catch (e: ClassNotFoundException){
            println("NO SE HA ENCONTRADO LA CLASE DEL DRIVER, REVISA LA LIBRERIA JDBC")
            e.printStackTrace();
            null;
        }catch (e: SQLException){
            println("HA OCURRIDO UN ERROR EN LA CONEXION SQL, REVISA LA CLASE DE CONEXION")
            e.printStackTrace();
            null;
        }
    }

}