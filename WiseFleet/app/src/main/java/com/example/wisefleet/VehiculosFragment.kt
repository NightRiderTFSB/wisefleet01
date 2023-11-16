package com.example.wisefleet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.backend.RecyclerViews.EmpleadosAdapter
import com.example.wisefleet.backend.RecyclerViews.PedidosAdapter
import com.example.wisefleet.backend.RecyclerViews.VehiculosAdapter
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiVehiculo
import com.example.wisefleet.backend.dataobjects.Usuario
import com.example.wisefleet.backend.dataobjects.Vehiculo
import com.example.wisefleet.databinding.FragmentConfiguracionBinding
import com.example.wisefleet.databinding.FragmentEmpleadosBinding
import com.example.wisefleet.databinding.FragmentVehiculosBinding

import com.google.android.material.floatingactionbutton.FloatingActionButton

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class VehiculosFragment() : Fragment() {

    private lateinit var apiVehiculo: ApiVehiculo;
    private var apiService: ApiService = ApiService()
    private var vehiculos: List<Vehiculo> = listOf()

    private lateinit var binding: FragmentVehiculosBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehiculosBinding.inflate(layoutInflater)
        val view = binding.root

        var fabs: FloatingActionButton? = binding.btnAddVehiculo
        fabs?.setOnClickListener {
            IniciarActivity(NuevoEditarVehiculoActivity())
        }

        GlobalScope.launch(Dispatchers.IO){
            try{
                apiVehiculo = apiService.conectarApiVehiculo()
                vehiculos = apiVehiculo.getVehiculos(apiService.apiKey)
                println(vehiculos)

                withContext(Dispatchers.Main) {
                    // Ahora estás en el hilo principal
                    println("VEHICULOS: " + vehiculos[0].modelo)
                    val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerVehiculos)
                    val adapter = VehiculosAdapter(vehiculos)
                    recyclerView?.layoutManager = LinearLayoutManager(requireContext())
                    recyclerView?.adapter = adapter

                    adapter.onItemClickListener = object : VehiculosAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(requireContext(), EstadisticasActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }

            }catch (error: Exception){
                println("ERROR EN LA API VEHICULOS")
                error.printStackTrace()
            }
        }



        return view
    }

    fun IniciarActivity(activity: Activity) {
        val intent = Intent(this.activity, activity::class.java)
        startActivity(intent)
    }

}