package com.example.smartcarapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.Cliente_Activity
import com.example.smartcarapp.ui.fragments.Compras.compras_fecha
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_inicio, container, false)

        val btnBusqueda: Button = view.findViewById(R.id.btn_busqueda)

        val tvPrueba: TextView = view.findViewById(R.id.tvPrueba)

        btnBusqueda.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.nav_inicio_compras_fecha)
        }

        val db = FirebaseFirestore.getInstance()

        db.collection("prueba")
            .addSnapshotListener { snapshots, e ->
                if( e != null){
                    Log.w("Firebase", "Error al Consultar Cursos")
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges){
                    Log.i("FirebaseUESAN","Recorriendo documentos")
                    when(dc.type){
                        DocumentChange.Type.ADDED -> {
                            Log.d("Firebase","Data: "+ dc.document.data)
                            tvPrueba.text = dc.document.data["saludo"].toString()
                        }
                        DocumentChange.Type.MODIFIED ->{
                            tvPrueba.text = dc.document.data["saludo"].toString()
                        }
                        //DocumentChange.Type.REMOVED ->Log.d("Firebase",
                        //"Removed Data" + dc.document.data)

                        else -> {
                            Log.e("Firebase", "Error in document")
                        }
                    }
                }
            }

        // Probando github
        return view
    }

}