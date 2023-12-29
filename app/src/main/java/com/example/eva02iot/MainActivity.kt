package com.example.eva02iot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.eva02iot.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var textViewSteps: TextView
    //Firebase DB

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewSteps = binding.textViewSteps

        //Inicio de DB y ruta de almacenamiento

        database = FirebaseDatabase.getInstance().getReference("datos/pasos")

        //Generacion de ID unico

        val id = database.child("Pasos").push().key

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Obtener el valor de pasos y mostrarlo en el TextView
                val steps = dataSnapshot.getValue(Long::class.java) ?: 0
                textViewSteps.text = "Pasos: $steps"
            }


            override fun onCancelled(databaseError: DatabaseError) {
                // Manejar errores de conexión o lectura de la base de datos
                Log.e("Firebase", "Error al obtener datos: ${databaseError.message}")
            }

        })
    }
}