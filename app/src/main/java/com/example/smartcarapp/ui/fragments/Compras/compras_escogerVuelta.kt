package com.example.smartcarapp.ui.fragments.Compras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.smartcarapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class compras_escogerVuelta : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout._compras_escoger_vuelta, container, false)

        //val btnContinuar: Button = view.findViewById(R.id.btn_continuar_Ida)

        //btnContinuar.setOnClickListener{ view ->
        //    view.findNavController().navigate(R.id.action_compras_fecha_to_compras_cantPasajeros)
        //}

        return view


    }

}