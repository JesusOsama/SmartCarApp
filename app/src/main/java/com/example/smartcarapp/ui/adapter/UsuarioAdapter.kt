package com.example.smartcarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.model.UsuarioModel

// Listado del Administrador
class UsuarioAdapter(private var lstUsuario: List<UsuarioModel>):
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvDni: TextView = itemView.findViewById(R.id.tvDniLista)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombreLista)
        val tvApellido: TextView = itemView.findViewById(R.id.tvApellidoLista)
        val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreoLista)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_usuario,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemUsuario = lstUsuario[position]
        holder.tvDni.text = itemUsuario.dni
        holder.tvNombre.text = itemUsuario.nombre
        holder.tvApellido.text = itemUsuario.apellido
        holder.tvCorreo.text = itemUsuario.correo
    }

    override fun getItemCount(): Int {
        return lstUsuario.size
    }

}