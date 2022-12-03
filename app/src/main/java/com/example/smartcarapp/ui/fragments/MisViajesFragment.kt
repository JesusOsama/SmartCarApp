package com.example.smartcarapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.Cliente_Activity
import com.example.smartcarapp.ui.adapter.HistorialAdapter
import com.example.smartcarapp.ui.model.BoletoModel
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MisViajesFragment : Fragment() {
    var dni: String=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_mis_viajes, container, false)
        val db = FirebaseFirestore.getInstance()
        val lstBoletos:ArrayList<BoletoModel> = ArrayList()
        val rvHistorial: RecyclerView = view.findViewById(R.id.rvHistorial)

        val correo = (activity as Cliente_Activity).correoUsuarioActual

        db.collection("Usuario").whereIn("correo", listOf(correo))
            .addSnapshotListener {snapshots, e->
                if(e!=null){
                    Log.e("Firebase error","Error ")
                    return@addSnapshotListener
                }
                for (dc in snapshots!!.documentChanges){
                    Log.i("FirebaseUESAN","Recorriendo Usuario")
                    when(dc.type){
                        DocumentChange.Type.ADDED,
                        DocumentChange.Type.MODIFIED,
                        DocumentChange.Type.REMOVED -> {
                            Log.d("Firebase","Data: "+ dc.document.data)
                            dni = dc.document.data["dni"].toString()
                        }
                        else -> {
                            Log.e("Firebase", "Error in document")
                        }
                    }
                }
            }

        db.collection("Boleto").whereIn("dniPasajero", listOf(dni))
            .addSnapshotListener {snap, e->
                if(e!=null){
                    Log.e("Firebase error","Error ")
                    return@addSnapshotListener
                }
                for(dc in  snap!!.documentChanges){
                    Log.i("FirebaseUESAN","Recorriendo Boleto")
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
                rvHistorial.adapter = HistorialAdapter(lstBoletos)
                rvHistorial.layoutManager = LinearLayoutManager(requireContext())
            }

        return view
    }

}