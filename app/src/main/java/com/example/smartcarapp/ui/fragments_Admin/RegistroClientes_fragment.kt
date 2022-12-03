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


class RegistroClientes_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view: View = inflater.inflate(R.layout.fragment_registro_clientes_fragment, container, false)
        val btnRegistrarC: Button = view.findViewById(R.id.btnRegistrarC)
        val etNombres: EditText = view.findViewById(R.id.etNombres)
        val etApellidos: EditText = view.findViewById(R.id.etApellidosC)
        val etCorreoC: EditText = view.findViewById(R.id.etCorreoC)
        val etDNI: EditText = view.findViewById(R.id.etDNI)

        btnRegistrarC.setOnClickListener{
            var nombresValue = etNombres.text
            var apellidosValue = etApellidos.text
            var correoCValue = etCorreoC.text
            val dniCValue = etDNI.text


            Toast.makeText(requireContext(), "Nombres: $nombresValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Apellidos: $apellidosValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Correo: $correoCValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "DNI: $dniCValue", Toast.LENGTH_SHORT).show()


        }

        return view
    }

}