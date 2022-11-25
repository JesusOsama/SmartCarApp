package com.example.smartcarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.model.BoletoModel

class BoletoAdapter(private var lstBoleto: List<BoletoModel>):
    RecyclerView.Adapter<BoletoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvPlaca: TextView = itemView.findViewById(R.id.tvBus)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
        val tvCosto: TextView = itemView.findViewById(R.id.tvCosto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_boleto,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBoleto = lstBoleto[position]
        holder.tvPlaca.text = itemBoleto.placaBus
        holder.tvFecha.text = itemBoleto.fechaSalida
        holder.tvCosto.text = itemBoleto.costo
    }

    override fun getItemCount(): Int {
        return lstBoleto.size
    }


}