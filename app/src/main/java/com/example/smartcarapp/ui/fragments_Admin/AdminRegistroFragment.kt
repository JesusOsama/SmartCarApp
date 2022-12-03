package com.example.smartcarapp.ui.fragments_Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.smartcarapp.R


class AdminRegistroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view: View = inflater.inflate(R.layout.fragment_admin_registro, container, false)
        val btnCliente: Button = view.findViewById(R.id.btnRegCliente)
        val btnFlota: Button = view.findViewById(R.id.btnRegFlota)
        val btnRuta: Button = view.findViewById(R.id.btnRegRuta)
        val btnBoletos: Button = view.findViewById(R.id.btnRegBoletos)

        btnCliente.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_navRegistro_to_registroClientes_fragment)
        }
        btnRuta.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_registro_ruta_fragment_to_navRegistro)
        }
        btnBoletos.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_registro_boletos_fragment_to_navRegistro)
        }
        btnFlota.setOnClickListener{ view ->

            view.findNavController().navigate(R.id.action_registro_flota_fragment_to_navRegistro)
        }
        return view
    }

}