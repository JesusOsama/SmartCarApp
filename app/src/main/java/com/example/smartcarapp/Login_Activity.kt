package com.example.smartcarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.smartcarapp.ui.Cliente_Activity

class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.button_Login)

        // Cambiar a layout ya logeado
        btnLogin.setOnClickListener{
            val intent = Intent(this, Cliente_Activity::class.java)
            startActivity(intent)
        }
    }

}