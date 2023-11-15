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
import com.example.wisefleet.backend.RecyclerViews.PedidosAdapter
import com.example.wisefleet.backend.RecyclerViews.ReportesAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReportesUsoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reportesuso, container, false)

        val fab: FloatingActionButton? = view?.findViewById(R.id.btnAddReporte)
        fab?.setOnClickListener {
            IniciarActivity(NuevoEditarReporteUsoActivity())
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerReportesUso)
        val adapter = ReportesAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        adapter.onItemClickListener = object : ReportesAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), DetalleReporteUsoActivity::class.java)
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