package com.example.smartcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.smartcarapp.ui.Cliente_Activity
import com.google.firebase.auth.FirebaseAuth

class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = FirebaseAuth.getInstance()
        val txtEmail: EditText = findViewById(R.id.txtEmail)
        val txtPassword: EditText = findViewById(R.id.txtPassword)
        val btnLogin: Button = findViewById(R.id.button_Login)



        btnLogin.setOnClickListener{
            val correo = txtEmail.text.toString()
            val clave = txtPassword.text.toString()

            db.signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Inicio satisfactorio", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Cliente_Activity::class.java)
                        intent.putExtra("correo", correo)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Correo o clave incorrecta", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}