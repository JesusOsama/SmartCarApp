package com.example.smartcarapp.ui.fragments.Compras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import androidx.navigation.findNavController
import com.example.smartcarapp.R

class compras_fecha : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout._compras_fecha, container, false)

        val calendar: CalendarView= view.findViewById(R.id.calendarView)
        val btnContinuar: Button = view.findViewById(R.id.btn_cont_fecha)

        calendar.setOnDateChangeListener(
            CalendarView.OnDateChangeListener{ _, year, month, dayOfMonth ->
                val fecha= (dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
            })



        var codeViaje = arguments?.getString("datosViaje")



        btnContinuar.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_compras_fecha_to_compras_cantPasajeros)
        }

        return view
    }
}

