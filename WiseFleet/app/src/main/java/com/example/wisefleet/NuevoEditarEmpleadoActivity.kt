package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiEmpleado
import com.example.wisefleet.backend.dataobjects.Empleado
import com.example.wisefleet.databinding.ActivityNuevoEditarEmpleadoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class NuevoEditarEmpleadoActivity(empleadox: Empleado?) : AppCompatActivity() {

    private var apiService = ApiService();
    private lateinit var apiEmpleado: ApiEmpleado;
    private lateinit var empleado:Empleado;
    private lateinit var binding: ActivityNuevoEditarEmpleadoBinding;
    constructor(): this  (null){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevoEditarEmpleadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch(Dispatchers.IO){
            apiEmpleado = apiService.conectarApiEmpleado()
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }

        binding.btnGuardarEmpleado.setOnClickListener {
            /*GlobalScope.launch(Dispatchers.IO) {
                var empleadoy = Empleado(binding.txtNombre.text.toString(),
                                                    binding.txtApellidoPaterno.text.toString(),
                                                    binding.txtApellidoMaterno.text.toString(),
                                                    binding.txtCodigoEmpleado.text.toString(),
                                                    binding.txtTelefono.text.toString())

                agregarEmpleado(empleadoy)
            }*/
        }
    }

    suspend fun agregarEmpleado(empleado: Empleado){
        try{
            apiEmpleado.createEmpleado(empleado, apiService.apiKey)
        }catch (error: Exception){
            error.printStackTrace()
        }
    }
}