package com.example.smartcarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smartcarapp.Login_Activity
import com.example.smartcarapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class Register_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val dbU = FirebaseAuth.getInstance()
        val db= FirebaseFirestore.getInstance()

        val etCorreo: EditText = findViewById(R.id.etCorreo)
        val etContraseña: EditText = findViewById(R.id.etContra)
        val etnombres: EditText = findViewById(R.id.etNombre)
        val etapellidos:EditText = findViewById(R.id.etApellidos)
        val btnReg: Button =findViewById(R.id.btnRegistrar)

        btnReg.setOnClickListener {

            if(etnombres.text.toString().isEmpty()){
                etnombres.requestFocus()
                etnombres.setError("Ingrese nombre")
            }else if(etapellidos.text.toString().isEmpty()){
                etapellidos.requestFocus()
                etapellidos.setError("Ingrese apellidos")
            }else if(etCorreo.text.toString().isEmpty()){
                etCorreo.requestFocus()
                etCorreo.setError("Ingrese email")
            }else if(etContraseña.text.toString().length<6){
                etContraseña.requestFocus()
                etContraseña.setError("La contraseña debe tener una longitud mayor a 6")
            }else{
                val email= etCorreo.text.toString()
                val password = etContraseña.text.toString()
                val nombres=etnombres.text.toString()
                val apellidos=etapellidos.text.toString()

                dbU.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    val user: FirebaseUser? = dbU.getCurrentUser()
                    val idUser: String = user!!.uid
                    val datosUsuarios = UsuariosModel(
                        nombres,
                        apellidos,
                        email,
                        password,
                    )
                    db.collection("Voluntarios").document(idUser).set(datosUsuarios)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Nuevo Usuario registrado", Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this, Login_Activity::class.java)
                            startActivity(intent)
                        }.addOnFailureListener {
                            Toast.makeText(this, "Ha ocurrido un error al registrar", Toast.LENGTH_LONG).show()
                        }
                }
            }





    }
}