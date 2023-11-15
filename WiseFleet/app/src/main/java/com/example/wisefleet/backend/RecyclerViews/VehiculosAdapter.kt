package com.example.wisefleet.backend.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.R
import com.example.wisefleet.backend.dataobjects.Vehiculo

class VehiculosAdapter(vehiculox: List<Vehiculo>): RecyclerView.Adapter<VehiculosAdapter.ViewHolder>() {

    var vehiculos: List<Vehiculo> = vehiculox

    val modelos = arrayOf("Honda Wave", "Ducati F1", "Italika F150", "Honda H1")
    val disponibilidad = arrayOf("pizza", "hamburguesa", "tacos", "papas")

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var modelo: TextView
        var disponible: TextView

        init {
            modelo = itemView.findViewById(R.id.txtNombreVehiculo)
            disponible = itemView.findViewById(R.id.txtDisponibilidad)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VehiculosAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_vehiculos, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: VehiculosAdapter.ViewHolder, position: Int) {
        viewHolder.modelo.text = vehiculos[position].modelo
        viewHolder.disponible.text = if (vehiculos[position].disponible) "Disponible" else "No disponible"
    }

    override fun getItemCount(): Int {
        return vehiculos.size
    }

}