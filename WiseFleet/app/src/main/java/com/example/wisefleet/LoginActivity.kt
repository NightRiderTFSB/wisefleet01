package com.example.wisefleet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiUsuario
import com.example.wisefleet.backend.dataobjects.Usuario
import com.example.wisefleet.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiService: ApiService;
    private lateinit var apiUsuario: ApiUsuario
    private lateinit var usuario: List<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = ApiService()
        usuario = listOf()

        GlobalScope.launch {
            try{
                apiUsuario = apiService.conectarApiUsuario()
                //var usuario: List<Usuario> = apiUsuario.usuarioLogin("eq.starboy","eq.starboy", apiService.apikeyUsuario)
                //var usuarioo: List<Usuario> = apiUsuario.getUsuario("eq."+1, apiService.apikeyUsuario)
                //println("USUARIO: " + usuarioo)
                //Toast.makeText(null, "CONECTADO prro", Toast.LENGTH_LONG)
                delay(3000)
            }catch (error: Exception){
                println("HA OCURRIDO ERROR EN OBTENER EL API USUARIO");
                //Toast.makeText(null, "NO CONECTADO prro", Toast.LENGTH_LONG)
                error.printStackTrace()
            }
        }

        binding.btnIniciarSesion.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                try{
                    usuario = apiUsuario.usuarioLogin("eq."+binding.txtUsuario.text, "eq."+binding.txtContrasena.text, apiService.apiKey)
                    println(usuario)
                    delay(300)

                    runOnUiThread {
                        if(!usuario.isEmpty()){
                            println("Bienvenido")
                            Toast.makeText(this@LoginActivity, "Bienvenido", Toast.LENGTH_LONG).show()
                            val lanzar = Intent(this@LoginActivity, MainActivity::class.java)
                            lanzar.putExtra("usuario", usuario[0])
                            startActivity(lanzar)
                        }else{
                            println("Malvenido")
                            Toast.makeText(this@LoginActivity, "Revisa tus credenciales", Toast.LENGTH_LONG).show()
                        }
                    }

                }catch (error: Exception){
                    println("HA OCURRIDO ERROR EN OBTENER EL API USUARIO");
                    //Toast.makeText(null, "NO CONECTADO prro", Toast.LENGTH_LONG)
                    error.printStackTrace()
                }
            }



        }



    }
}