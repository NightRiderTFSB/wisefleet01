package com.example.wisefleet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.backend.RecyclerViews.VehiculosAdapter
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.apis.ApiVehiculo
import com.example.wisefleet.backend.dataobjects.Vehiculo
import com.example.wisefleet.databinding.FragmentConfiguracionBinding

import com.google.android.material.floatingactionbutton.FloatingActionButton

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class VehiculosFragment() : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_vehiculos, container, false)

        val fab: FloatingActionButton? = view?.findViewById(R.id.btnAddVehiculo)
        fab?.setOnClickListener {
            IniciarActivity(NuevoEditarVehiculoActivity())
        }

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

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerVehiculos)
        val adapter = VehiculosAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Inicializa el activiy para vizualizar los detalles del item seleccionado del recyclerView
        adapter.onItemClickListener = object : VehiculosAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), EstadisticasActivity::class.java)
                startActivity(intent)
            }
        }

        return view
    }

    fun IniciarActivity(activity: Activity) {
        val intent = Intent(this.activity, activity::class.java)
        startActivity(intent)
    }

}