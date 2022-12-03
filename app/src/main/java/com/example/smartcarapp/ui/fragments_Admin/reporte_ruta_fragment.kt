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


class reporte_ruta_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view: View = inflater.inflate(R.layout.fragment_registro_boletos_fragment, container, false)
        val btnRegistrarB: Button = view.findViewById(R.id.btnRegistrarBol)
        val etRuta: EditText = view.findViewById(R.id.etRuta)
        val etFlota: EditText = view.findViewById(R.id.etFlota)
        val etHoraSalida: EditText = view.findViewById(R.id.etHoraSalidaB)

        btnRegistrarB.setOnClickListener{
            var rutaValue = etRuta.text
            var flotaValue = etFlota.text
            var horaSalidaValue = etHoraSalida.text


            Toast.makeText(requireContext(), "Ruta: $rutaValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Flota: $flotaValue", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Hora de Salida: $horaSalidaValue", Toast.LENGTH_SHORT).show()


        }

        return view
    }

}