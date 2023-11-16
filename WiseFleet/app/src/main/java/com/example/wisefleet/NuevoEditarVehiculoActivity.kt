package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiVehiculo
import com.example.wisefleet.backend.dataobjects.Vehiculo
import com.example.wisefleet.databinding.ActivityMainBinding
import com.example.wisefleet.databinding.ActivityNuevoEditarEmpleadoBinding
import com.example.wisefleet.databinding.ActivityNuevoEditarVehiculoBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NuevoEditarVehiculoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuevoEditarVehiculoBinding
    private var apiService = ApiService();
    private lateinit var apiVehiculo: ApiVehiculo;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevoEditarVehiculoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch(Dispatchers.IO) {
            apiVehiculo = apiService.conectarApiVehiculo()
        }

        suspend fun agregarVehiculo(){
            try{
                var vehiculo = Vehiculo(binding.txtModelo.text.toString(),
                                        binding.txtAno.text.toString(),
                                        binding.txtColor.text.toString(),
                                        binding.txtMatricula.text.toString(),
                                        binding.txtNoTarjeta.text.toString(),
                                        binding.txtKmGasolina.text.toString().toFloat(),
                                        true)
                apiVehiculo.createVehiculo(vehiculo, apiService.apiKey)
            }catch (error: Exception){
                println("HA OCURRIDO UN ERROR AL INTENTAR INSERTAR UN VEHICULO")
                error.printStackTrace()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }

        binding.btnGuardarVehiculo.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                agregarVehiculo()
            }
        }

    }
}