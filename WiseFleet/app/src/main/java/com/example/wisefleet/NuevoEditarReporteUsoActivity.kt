package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NuevoEditarReporteUsoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_editar_reporte_uso)

        val btnVolver = findViewById<FloatingActionButton>(R.id.btnVolver)
        val btnAgregar = findViewById<FloatingActionButton>(R.id.btnGuardarReporte)

        btnVolver.setOnClickListener {
            finish()
        }

        btnAgregar.setOnClickListener {
            finish()
        }
    }
}