package com.example.smartcarapp.ui.fragments_Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smartcarapp.R


class registro_flota_fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view: View = inflater.inflate(R.layout.fragment_registro_flota_fragment, container, false)
        val btnRegistrarV: Button = view.findViewById(R.id.btnRegistrarV)
        val etAñoFab: EditText = view.findViewById(R.id.etAñoFab)
        val etMarca: EditText = view.findViewById(R.id.etMarca)
        val etModelo: EditText = view.findViewById(R.id.etModelo)
        val etColor: EditText = view.findViewById(R.id.etColor)
        val etCantAsientos: EditText = view.findViewById(R.id.etCantAsientos)

        btnRegistrarV.setOnClickListener{
            val añoValue = etAñoFab.text
            var marcaValue = etMarca.text
            var modeloValue = etModelo.text
            var colorValue = etColor.text
            val cantAsientosValue = etCantAsientos.text


            Toast.makeText(requireContext(), "Año de Fabricacion: $añoValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Marca: $marcaValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Modelo: $modeloValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Color: $etColor", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Cantidad de Asientos: $etCantAsientos", Toast.LENGTH_SHORT).show()

        }

        return view
    }

}