package com.example.wisefleet.backend.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.R

class ReportesAdapter: RecyclerView.Adapter<ReportesAdapter.ViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null
    val modelos = arrayOf("Honda wave", "Italika", "ei", "moto")
    val descripciones = arrayOf("embrague duro", "medio tanque de gasolina agotado", "no c", "4")
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ReportesAdapter.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_reportesuso, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ReportesAdapter.ViewHolder, position: Int) {
        viewHolder.Modelo.text =modelos[position]
        viewHolder.Descripción.text = descripciones[position]

        viewHolder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var Modelo: TextView
        var Descripción: TextView

        init {
            Modelo = itemView.findViewById(R.id.txtModelo)
            Descripción = itemView.findViewById(R.id.txtDescripcionUso)
        }

    }

    override fun getItemCount(): Int {
        return modelos.size
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}