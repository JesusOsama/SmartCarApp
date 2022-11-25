package com.example.smartcarapp.ui.fragments.Compras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.smartcarapp.R


class compras_cantPasajeros : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var contadorAdul = 0
        var contadorNinos = 0
        var contadorInf = 0
        val view: View = inflater.inflate(R.layout._compras_cant_pasajeros, container, false)
        val btnContinuar: Button = view.findViewById(R.id.btn_cont_Cantidad)
        val btnSumAdul: Button = view.findViewById(R.id.btn_plusAdultos)
        val btnRestAdul: Button = view.findViewById(R.id.btn_minAdultos)
        val btnSumNi: Button = view.findViewById(R.id.btn_plusNinos)
        val btnRestNi: Button = view.findViewById(R.id.btn_minNinos)
        val btnSumInf: Button = view.findViewById(R.id.btn_plusInfan)
        val btnRestInf: Button = view.findViewById(R.id.btn_minInfan)
        val tvAdultos: TextView = view.findViewById(R.id.tvAdul)
        val tvNinos: TextView = view.findViewById(R.id.tvNi)
        val tvInf: TextView = view.findViewById(R.id.tvInf)


        btnContinuar.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_compras_cantPasajeros_to_compras_escogerIda)
        }

        btnSumAdul.setOnClickListener{
            if (contadorAdul >= 9){
                contadorAdul = 9
            }else{
                contadorAdul += 1;
            }
            tvAdultos.setText(""+contadorAdul)
        }

        btnRestAdul.setOnClickListener {
            if (contadorAdul <= 0){
                contadorAdul = 0
            }else{
                contadorAdul -= 1;
            }
            tvAdultos.setText(""+contadorAdul)
        }

        btnSumNi.setOnClickListener {
            if (contadorNinos >= 9){
                contadorNinos = 9
            }else{
                contadorNinos += 1;
            }
            tvNinos.setText(""+contadorNinos)
        }

        btnRestNi.setOnClickListener {
            if (contadorNinos <= 0){
                contadorNinos = 0
            }else{
                contadorNinos -= 1;
            }
            tvNinos.setText(""+contadorNinos)
        }

        btnSumInf.setOnClickListener {
            if (contadorInf >= 9){
                contadorInf = 9
            }else{
                contadorInf += 1;
            }

            tvInf.setText(""+contadorInf)
        }

        btnRestInf.setOnClickListener{
            if (contadorInf <= 0){
                contadorInf = 0
            }else{
                contadorInf -= 1;
            }
            tvInf.setText(""+contadorInf)
        }
        return view
    }
}