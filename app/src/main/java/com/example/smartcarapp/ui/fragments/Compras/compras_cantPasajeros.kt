package com.example.smartcarapp.ui.fragments.Compras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.smartcarapp.R


class compras_cantPasajeros : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout._compras_cant_pasajeros, container, false)

        val btnContinuar: Button = view.findViewById(R.id.btn_cont_Cantidad)

        btnContinuar.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_compras_cantPasajeros_to_compras_escogerIda)
        }

        return view

    }


}