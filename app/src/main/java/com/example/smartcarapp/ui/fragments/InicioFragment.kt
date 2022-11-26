package com.example.smartcarapp.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.smartcarapp.R



class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_inicio, container, false)

        val spnSalida: Spinner = view.findViewById(R.id.spn_InicioViaje)
        val spnLLegada: Spinner = view.findViewById(R.id.spn_FinViaje)

        val btnBusqueda: Button = view.findViewById(R.id.btn_busqueda)

        btnBusqueda.setOnClickListener{ view ->
            var salida: String = spnSalida.selectedItem.toString()
            var llegada: String = spnLLegada.selectedItem.toString()

            var codeBoletos: String = codeBoletos(salida)+"-"+codeBoletos(llegada)

            val bundle = bundleOf("datosViaje" to codeBoletos)

            if(salida != llegada){
                view.findNavController().navigate(R.id.nav_inicio_compras_fecha, bundle)
            }else{
                Toast.makeText(requireActivity(),"Escoja diferentes ciudades", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

}

fun codeBoletos (lugar: String): String {
    var code: String
    if(lugar == "Trujillo"){
        code="TRU"
    }else if (lugar == "Huancayo"){
        code="HUAN"
    }else{
        code="LIM"
    }
    return code
}