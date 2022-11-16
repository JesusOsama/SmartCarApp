package com.example.smartcarapp.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.smartcarapp.R
import com.example.smartcarapp.databinding.ActivityClienteBinding

class Cliente_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityClienteBinding
    var correoUsuarioActual: String? = null

    companion object {
        val instance = Cliente_Activity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        correoUsuarioActual = intent.getStringExtra("correo")

        binding = ActivityClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_cliente)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navInicio, R.id.navMisViajes, R.id.navPerfil
            )
        )

        //navController.navigate(R.id.navPerfil, bundleOf("correo" to correoUsuarioActual))

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}