package com.example.wisefleet

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.lang.Exception
import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.app.appsearch.GlobalSearchSession


import androidx.fragment.app.Fragment
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiUsuario
import com.example.wisefleet.backend.dataobjects.Usuario
import com.example.wisefleet.databinding.ActivityMainBinding

import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity(){
    private var doubleBackToExitPressedOnce = false
    private lateinit var binding : ActivityMainBinding
    private lateinit var usuario: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        usuario = intent.getSerializableExtra("usuario") as Usuario
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(PedidosFragment(usuario))

        val colorOriginal: Int = findViewById<TextView>(R.id.btnPedidos).getCurrentTextColor()
        val btnPedidos = findViewById<TextView>(R.id.btnPedidos)
        val btnVehiculos = findViewById<TextView>(R.id.btnVehiculos)
        val btnEmpleados = findViewById<TextView>(R.id.btnEmpleados)

        btnPedidos.setTextColor(ContextCompat.getColor(this, R.color.Primary))
        btnPedidos.setTypeface(null, Typeface.BOLD)





        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Pedidos -> {
                    btnVehiculos.visibility = View.VISIBLE
                    btnPedidos.visibility = View.VISIBLE
                    btnEmpleados.visibility = View.VISIBLE
                    replaceFragment(PedidosFragment(usuario))

                    btnPedidos.setTextColor(ContextCompat.getColor(this, R.color.Primary))
                    btnPedidos.setTypeface(null, Typeface.BOLD)

                    btnEmpleados.setTextColor(colorOriginal)
                    btnEmpleados.setTypeface(null, Typeface.NORMAL)

                    btnVehiculos.setTextColor(colorOriginal)
                    btnVehiculos.setTypeface(null, Typeface.NORMAL)
                }

                R.id.ReportesUso ->{
                    btnVehiculos.visibility = View.INVISIBLE
                    btnPedidos.visibility = View.INVISIBLE
                    btnEmpleados.visibility = View.INVISIBLE
                    replaceFragment(ReportesUsoFragment())
                }

                R.id.Configuracion ->{
                    btnVehiculos.visibility = View.INVISIBLE
                    btnPedidos.visibility = View.INVISIBLE
                    btnEmpleados.visibility = View.INVISIBLE
                    replaceFragment(ConfiguracionFragment())
                }
                else -> {
                }
            }
            true
        }

        val fragmentVehiculos = findViewById<TextView>(R.id.btnVehiculos)
        fragmentVehiculos.setOnClickListener {
            replaceFragment(VehiculosFragment())
            btnPedidos.setTextColor(colorOriginal)
            btnPedidos.setTypeface(null, Typeface.NORMAL)
            btnEmpleados.setTextColor(colorOriginal)
            btnEmpleados.setTypeface(null, Typeface.NORMAL)

            btnVehiculos.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            btnVehiculos.setTypeface(null, Typeface.BOLD)
        }

        val fragmentPedidos = findViewById<TextView>(R.id.btnPedidos)
        fragmentPedidos.setOnClickListener {
            replaceFragment(PedidosFragment(usuario))

            btnPedidos.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            btnPedidos.setTypeface(null, Typeface.BOLD)

            btnEmpleados.setTextColor(colorOriginal)
            btnEmpleados.setTypeface(null, Typeface.NORMAL)

            btnVehiculos.setTextColor(colorOriginal)
            btnVehiculos.setTypeface(null, Typeface.NORMAL)
        }

        val fragmentEmpleados = findViewById<TextView>(R.id.btnEmpleados)
        fragmentEmpleados.setOnClickListener {
            replaceFragment(EmpleadosFragment())

            btnEmpleados.setTextColor(ContextCompat.getColor(this, R.color.Primary))
            btnEmpleados.setTypeface(null, Typeface.BOLD)

            btnPedidos.setTextColor(colorOriginal)
            btnPedidos.setTypeface(null, Typeface.NORMAL)

            btnVehiculos.setTextColor(colorOriginal)
            btnVehiculos.setTypeface(null, Typeface.NORMAL)
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Presiona nuevamente para salir", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000) // 2000 milisegundos (2 segundos) para presionar nuevamente y salir

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