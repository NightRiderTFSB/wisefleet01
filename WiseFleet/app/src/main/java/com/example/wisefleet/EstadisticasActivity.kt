package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.backend.RecyclerViews.EstadisticasAdapter
import com.example.wisefleet.backend.apis.ApiDatos
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.dataobjects.Datos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EstadisticasActivity : AppCompatActivity() {

    private var apiService: ApiService = ApiService()
    private lateinit var apiDatos: ApiDatos
    private lateinit var datos: List<Datos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        GlobalScope.launch(Dispatchers.Main) {
            apiDatos = apiService.conectarApiDatos()
            datos = apiDatos.getDatos(apiService.apiKey)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerEstadisticas)
            val adapter = EstadisticasAdapter(datos)
            recyclerView.layoutManager = LinearLayoutManager(this@EstadisticasActivity)
            recyclerView.adapter = adapter
        }

    }
}