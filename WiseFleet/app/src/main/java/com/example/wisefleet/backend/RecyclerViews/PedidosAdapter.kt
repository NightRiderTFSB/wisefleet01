package com.example.wisefleet.backend.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisefleet.R

class PedidosAdapter: RecyclerView.Adapter<PedidosAdapter.ViewHolder>(){

    val clientes = arrayOf("juan", "pedo", "anna")
    val descripcion = arrayOf("pizza", "hamburguesa", "tacos")
    val total = arrayOf("200", "60", "180")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_pedidos, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.cliente.text =clientes[position]
        viewHolder.descripcion.text = descripcion[position]
        viewHolder.total.text = total[position]
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var cliente: TextView
        var descripcion: TextView
        var total: TextView

        init {
            cliente = itemView.findViewById(R.id.txtANombreDe)
            descripcion = itemView.findViewById(R.id.txtANombreDe)
            total = itemView.findViewById(R.id.txtANombreDe)
        }

    }
}