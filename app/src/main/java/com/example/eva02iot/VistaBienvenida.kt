package com.example.eva02iot

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.eva02iot.databinding.ActivityMainBinding
import com.example.eva02iot.databinding.ActivityVistabienvenidaBinding
import com.example.eva02iot.vistas.LogrosFragment
import com.example.eva02iot.vistas.MetasFragment
import com.example.eva02iot.vistas.OpcionesFragment
import com.example.eva02iot.vistas.PasosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class VistaBienvenida : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistabienvenida)

        //Carga de fragment default

        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout,PasosFragment()).commit()
        }

        //Configuracion de BottomNavbar

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_pasos -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,PasosFragment()).commit()
                    true
                }
                R.id.nav_logros -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,LogrosFragment()).commit()
                    true
                }
                R.id.nav_metas -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,MetasFragment()).commit()
                    true
                }
                R.id.nav_opciones -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout,OpcionesFragment()).commit()
                    true
                }
                else -> false
            }
        }

        bottomNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.nav_pasos -> Toast.makeText(this, "Ya estás en la vista Pasos", Toast.LENGTH_SHORT).show()
                R.id.nav_logros -> Toast.makeText(this, "Ya estás en la vista Logros", Toast.LENGTH_SHORT).show()
                R.id.nav_metas -> Toast.makeText(this, "Ya estás en la vista Metas", Toast.LENGTH_SHORT).show()
                R.id.nav_opciones -> Toast.makeText(this, "Ya estás en la vista Opciones", Toast.LENGTH_SHORT).show()
                else -> false
            }
        }

    }
}