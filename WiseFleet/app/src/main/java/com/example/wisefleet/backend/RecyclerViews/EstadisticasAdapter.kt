package com.example.wisefleet.backend.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.R

class EstadisticasAdapter: RecyclerView.Adapter<EstadisticasAdapter.ViewHolder>() {

    val temperaturas = arrayOf("105°", "122°", "89°", "34°")
    val longitudes = arrayOf("23048230", "'0923'", "123133", "123123133")
    val latitudes = arrayOf("200", "60", "180", "50")

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var celcius: TextView
        var longitud: TextView
        var latitud: TextView

        init {
            celcius = itemView.findViewById(R.id.txtTemperatura)
            longitud = itemView.findViewById(R.id.txtLongitud)
            latitud = itemView.findViewById(R.id.txtLatitud)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): EstadisticasAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_estadisticas, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: EstadisticasAdapter.ViewHolder, position: Int) {
        viewHolder.celcius.text =temperaturas[position]
        viewHolder.longitud.text = longitudes[position]
        viewHolder.latitud.text = latitudes[position]
    }

    override fun getItemCount(): Int {
        return temperaturas.size
    }
}