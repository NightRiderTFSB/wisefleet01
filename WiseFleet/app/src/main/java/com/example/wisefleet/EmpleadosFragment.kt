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
import com.example.wisefleet.backend.RecyclerViews.EmpleadosAdapter
import com.example.wisefleet.backend.RecyclerViews.PedidosAdapter
import com.example.wisefleet.backend.apis.ApiEmpleado
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.dataobjects.Empleado
import com.example.wisefleet.databinding.FragmentEmpleadosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class EmpleadosFragment : Fragment() {

    private lateinit var apiEmpleado: ApiEmpleado
    private var apiService: ApiService = ApiService()
    private var empleados: List<Empleado> = mutableListOf()
    private lateinit var binding: FragmentEmpleadosBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEmpleadosBinding.inflate(layoutInflater)
        val view = binding.root

        var fabs: FloatingActionButton? = binding.btnAddEmpleado
        fabs?.setOnClickListener {
            IniciarActivity(NuevoEditarEmpleadoActivity())
        }

        GlobalScope.launch(Dispatchers.Main) {
            try {
                // Verificar si el fragmento está adjunto a la actividad
                if (isAdded) {
                    apiEmpleado = apiService.conectarApiEmpleado()
                    empleados = apiEmpleado.getEmpleados(apiService.apiKey)
                    println(empleados)

                    withContext(Dispatchers.Main) {
                        // Verificar nuevamente si el fragmento está adjunto a la actividad
                        if (isAdded) {
                            val recyclerView = binding.recyclerEmpleados
                            val adapter = EmpleadosAdapter(empleados)
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            recyclerView.adapter = adapter
                        }
                    }
                }

            } catch (error: Exception) {
                println("ERROR EN LA API EMPLEADOS")
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