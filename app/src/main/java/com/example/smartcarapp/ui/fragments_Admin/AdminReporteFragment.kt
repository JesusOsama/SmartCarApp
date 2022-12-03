package com.example.smartcarapp.ui.fragments_Admin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.smartcarapp.R

class AdminReporteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view: View = inflater.inflate(R.layout.fragment_admin_reporte, container, false)
        val btnReporteCliente: Button = view.findViewById(R.id.btnRepoCliente)
        val btnReporteBoletos: Button = view.findViewById(R.id.btnRepoBoletos)
        val btnReporteRuta: Button = view.findViewById(R.id.btnRepoRuta)

        btnReporteCliente.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_reporte_cliente_fragment_to_navReporte)
        }
        btnReporteBoletos.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_reporte_boletos_fragment_to_navReporte)
        }
        btnReporteRuta.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_reporte_ruta_fragment_to_navReporte)
        }
        return view
    }

}