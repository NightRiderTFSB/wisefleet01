package com.example.wisefleet.backend.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.R
import com.example.wisefleet.backend.dataobjects.Empleado

class EmpleadosAdapter(empleadox: List<Empleado>): RecyclerView.Adapter<EmpleadosAdapter.ViewHolder>() {

    var empleados = empleadox

    val numLicencias = arrayOf("3323", "32424", "324234", "34242")
    val nombres = arrayOf("Juan", "Luis Antonio", "El Joel", "El Cristal")
    val telefonos = arrayOf("3953293493", "3500402305", "2053020503", "0243503405")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EmpleadosAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_empleados, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: EmpleadosAdapter.ViewHolder, position: Int) {
        viewHolder.numLicencia.text = empleados[position].numleciencia
        viewHolder.nombre.text = empleados[position].nombre
        viewHolder.telefono.text = empleados[position].telefono
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var numLicencia: TextView
        var nombre: TextView
        var telefono: TextView

        init {
            numLicencia = itemView.findViewById(R.id.txtNumLicencia)
            nombre = itemView.findViewById(R.id.txtNombreEmpleado)
            telefono = itemView.findViewById(R.id.txtTelefono)
        }

    }

    override fun getItemCount(): Int {
        return empleados.size
    }
}