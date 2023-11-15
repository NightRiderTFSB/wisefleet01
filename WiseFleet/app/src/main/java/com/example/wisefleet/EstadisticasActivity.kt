package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.backend.RecyclerViews.EstadisticasAdapter
import com.example.wisefleet.backend.RecyclerViews.PedidosAdapter

class EstadisticasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerEstadisticas)
        val adapter = EstadisticasAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}