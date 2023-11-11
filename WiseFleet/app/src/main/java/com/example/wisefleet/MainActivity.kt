package com.example.wisefleet

import android.app.appsearch.GlobalSearchSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiUsuario
import com.example.wisefleet.backend.dataobjects.Usuario
import com.example.wisefleet.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.lang.Exception

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
    private lateinit var usuario: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.getSerializableExtra("usuario") as Usuario

        //replaceFragment(PedidosFragment(usuario))
        //replaceFragment(VehiculosFragment())
        replaceFragment(ReportesUsoFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.Vehiculos -> replaceFragment(VehiculosFragment())
                R.id.ReportesUso -> replaceFragment(ReportesUsoFragment())
                R.id.Configuracion -> replaceFragment(ConfiguracionFragment())

                else ->{



                }

            }

            true

        }


        if(usuario.permiso){
            Toast.makeText(this@MainActivity, "ERES ADMIN Y TU ID: " + usuario.idusuario, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@MainActivity, "NO ERES ADMIN", Toast.LENGTH_LONG).show()
        }

    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}