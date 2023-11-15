package com.example.wisefleet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.backend.RecyclerViews.EmpleadosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
class EmpleadosFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_empleados, container, false)

        val fab: FloatingActionButton? = view?.findViewById(R.id.btnAddEmpleado)
        fab?.setOnClickListener {
            IniciarActivity(NuevoEditarEmpleadoActivity())
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerEmpleados)
        val adapter = EmpleadosAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Inicializa el activiy para vizualizar los detalles del item seleccionado del recyclerView
        adapter.onItemClickListener = object : EmpleadosAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), DetalleEmpleadoActivity::class.java)
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