package com.example.smartcarapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smartcarapp.ui.Admin_Activity
import com.example.smartcarapp.ui.Cliente_Activity
import com.example.smartcarapp.ui.Register_Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlin.system.measureTimeMillis

class Login_Activity : AppCompatActivity() {
    var acceso: String = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = FirebaseAuth.getInstance()
        val txtEmail: EditText = findViewById(R.id.txtEmail)
        val txtPassword: EditText = findViewById(R.id.txtPassword)
        val btnLogin: Button = findViewById(R.id.button_Login)
        val btnReg:Button=findViewById(R.id.btnRegistro)

        btnLogin.setOnClickListener{
            val correo = txtEmail.text.toString()
            accesoAdmin(correo)

            val clave = txtPassword.text.toString()

            db.signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Inicio satisfactorio", Toast.LENGTH_LONG).show()
                        if(acceso == "1"){
                            val intent = Intent(this, Admin_Activity::class.java)
                            intent.putExtra("correo", correo)
                            startActivity(intent)
                        }else{
                            val intent = Intent(this, Cliente_Activity::class.java)
                            intent.putExtra("correo", correo)
                            startActivity(intent)
                        }
                    }else{
                        Toast.makeText(this,"Correo o clave incorrecta", Toast.LENGTH_LONG).show()
                    }
                }
        }

        btnReg.setOnClickListener {
                val intent = Intent(this,Register_Activity::class.java)
                startActivity(intent)
        }
    }

    fun accesoAdmin(correo: String){
        val db = FirebaseFirestore.getInstance()
        db.collection("Usuario")
            .whereEqualTo("correo", correo)
            .get()
            .addOnSuccessListener{ documents ->
                for (document in documents) {
                    acceso = document.data["estado"].toString()
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }

}