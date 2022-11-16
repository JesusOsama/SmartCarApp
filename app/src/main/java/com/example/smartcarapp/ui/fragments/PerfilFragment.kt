package com.example.smartcarapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.smartcarapp.Login_Activity
import com.example.smartcarapp.R
import com.example.smartcarapp.ui.Cliente_Activity
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.InternalChannelz.instance
import io.grpc.util.TransmitStatusRuntimeExceptionInterceptor.instance


class PerfilFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view: View = inflater.inflate(R.layout.fragment_perfil, container, false)
        val tvDni: TextView = view.findViewById(R.id.tvDni)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvApellido: TextView = view.findViewById(R.id.tvApellido)
        val tvCorreo: TextView = view.findViewById(R.id.tvCorreo)



        val correo = (activity as Cliente_Activity).correoUsuarioActual

        val db = FirebaseFirestore.getInstance()


        db.collection("Usuario").whereIn("correo", listOf(correo)) // Debe ir el correo del usuario que inicio sesión
            .addSnapshotListener { snapshots, e ->
                if( e != null){
                    Log.w("Firebase", "Error al Consultar Usuario")
                    return@addSnapshotListener
                }

                for (dc in snapshots!!.documentChanges){
                    Log.i("FirebaseUESAN","Recorriendo Usuario")
                    when(dc.type){
                        DocumentChange.Type.ADDED,
                        DocumentChange.Type.MODIFIED,
                        DocumentChange.Type.REMOVED -> {
                            Log.d("Firebase","Data: "+ dc.document.data)
                            tvDni.text = dc.document.data["dni"].toString()
                            tvNombre.text = dc.document.data["nombre"].toString()
                            tvApellido.text = dc.document.data["apellido"].toString()
                            tvCorreo.text = dc.document.data["correo"].toString()
                        }

                        else -> {
                            Log.e("Firebase", "Error in document")
                        }
                    }
                }
            }

        return view
    }

}