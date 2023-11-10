package com.example.wisefleet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NuevoEditarVehiculoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_editar_vehiculo)
        val btnVolver = findViewById<FloatingActionButton>(R.id.btnVolver)
        val btnAgregar = findViewById<FloatingActionButton>(R.id.btnGuardarVehiculo)

        btnVolver.setOnClickListener {
            finish()
        }

        btnAgregar.setOnClickListener {
            finish()
        }
    }
}