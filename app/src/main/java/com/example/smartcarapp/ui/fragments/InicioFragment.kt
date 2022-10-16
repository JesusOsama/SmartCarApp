package com.example.smartcarapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.Cliente_Activity
import com.example.smartcarapp.ui.fragments.Compras.compras_fecha


class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_inicio, container, false)

        val btnBusqueda: Button = view.findViewById(R.id.btn_busqueda)

        btnBusqueda.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.nav_inicio_compras_fecha)
        }

        return view
    }

}