package com.example.smartcarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.model.BoletoModel

class HistorialAdapter (private var lstBoleto: List<BoletoModel>):
    RecyclerView.Adapter<HistorialAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvFechaH: TextView = itemView.findViewById(R.id.tvFechaH)
        val tvTrayecto: TextView = itemView.findViewById(R.id.tvTrayecto)
        val tvCostoH: TextView = itemView.findViewById(R.id.tvCostoH)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_historial,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBoleto = lstBoleto[position]
        holder.tvFechaH.text = itemBoleto.fechaSalida
        holder.tvTrayecto.text = itemBoleto.ruta
        holder.tvCostoH.text = itemBoleto.costo
    }

    override fun getItemCount(): Int {
        return lstBoleto.size
    }
    }
