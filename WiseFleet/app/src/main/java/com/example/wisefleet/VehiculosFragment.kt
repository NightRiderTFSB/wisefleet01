package com.example.wisefleet

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiVehiculo
import com.example.wisefleet.backend.dataobjects.Vehiculo
import com.example.wisefleet.databinding.FragmentConfiguracionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class VehiculosFragment : Fragment() {

    private lateinit var apiVehiculo: ApiVehiculo;
    private var apiService: ApiService = ApiService()
    private var vehiculos: List<Vehiculo> = listOf()

    private var _binding: FragmentConfiguracionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        GlobalScope.launch(Dispatchers.IO){
            try{
                apiVehiculo = apiService.conectarApiVehiculo()
                vehiculos = apiVehiculo.getVehiculos(apiService.apiKey)
                println(vehiculos) 
            }catch (error: Exception){
                println("ERROR EN LA API VEHICULOS")
                error.printStackTrace()
            }
        }


        return inflater.inflate(R.layout.fragment_vehiculos, container, false)
    }

}