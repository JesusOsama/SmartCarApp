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


class registro_ruta_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view: View = inflater.inflate(R.layout.fragment_registro_ruta_fragment, container, false)
        val btnRegistrarR: Button = view.findViewById(R.id.btnRegistrarR)
        val etPuntoSalida: EditText = view.findViewById(R.id.etPuntoSalida)
        val etPuntoLlegada: EditText = view.findViewById(R.id.etPuntoLlegada)
        val etPrecio: EditText = view.findViewById(R.id.etPrecio)

        btnRegistrarR.setOnClickListener{
            var puntoSalidaValue = etPuntoSalida.text
            var puntoLlegadaValue = etPuntoLlegada.text
            val precioValue = etPrecio.text


            Toast.makeText(requireContext(), "Punto de Salida: $puntoSalidaValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Punto de Llegada: $puntoLlegadaValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Precio: $precioValue", Toast.LENGTH_SHORT).show()


        }

        return view
    }


}