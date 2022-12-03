package com.example.smartcarapp.ui.fragments.Compras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.adapter.BoletoAdapter
import com.example.smartcarapp.ui.model.BoletoModel
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore


class compras_escogerIda : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout._compras_escoger_ida, container, false)

        val btnContinuar: Button = view.findViewById(R.id.btn_cont_Ida)

        var ruta = arguments?.getString("lugares")

        val db = FirebaseFirestore.getInstance()
        val lstBoletos:ArrayList<BoletoModel> = ArrayList()
        val rvEscogerIda: RecyclerView = view.findViewById(R.id.rvEscogerIda)

        db.collection("Boleto").whereIn("ruta", listOf(ruta))
            .addSnapshotListener {snap, e->
                if(e!=null){
                    Log.e("Firebase error","Error ")
                    return@addSnapshotListener
                }

                for(dc in  snap!!.documentChanges){
                    when(dc.type){
                        DocumentChange.Type.ADDED,
                        DocumentChange.Type.MODIFIED,
                        DocumentChange.Type.REMOVED -> {
                            lstBoletos.add(
                                BoletoModel(dc.document.data["dniPasajero"].toString(),
                                    dc.document.data["placaBus"].toString(),
                                    dc.document.data["ruta"].toString(),
                                    dc.document.data["fecha"].toString(),
                                    dc.document.data["costo"].toString())
                            )
                        }
                    }
                }
                rvEscogerIda.adapter = BoletoAdapter(lstBoletos)
                rvEscogerIda.layoutManager = LinearLayoutManager(requireContext())
            }

        btnContinuar.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_compras_escogerIda_to_compras_pago)
        }

        return view
    }

}