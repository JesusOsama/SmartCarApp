package com.example.smartcarapp.ui.fragments_Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.smartcarapp.R


class Registro_Admin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.registro__admin, container, false)

        val btnRCliente: Button = view.findViewById(R.id.btnRCliente)

        //
        btnRCliente.setOnClickListener {
            view.findNavController().navigate(R.id.action_registro_Admin_to_registrar_Cliente)
        }

        return view






    }


}