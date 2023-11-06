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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Cambio a segunda vista

        binding.btnSignIn.setOnClickListener{
            try{
                val nombre: String = binding.Username.text.toString()
                val clave: String = binding.Clave.text.toString()
                val repetirclave : String = binding.RepetirClave.text.toString()

                if (nombre.isNotEmpty() && clave.isNotEmpty() && repetirclave.isNotEmpty() ){
                    val intent = Intent(this, VistaBienvenida::class.java)
                    intent.putExtra("nombre",nombre)
                    startActivity(intent)
                    Toast.makeText(this, "Bienvenido $nombre",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Faltan campos por llenar",Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception){
                Log.e("Error enviarNombre", e.message.toString())
            }

        }
        binding.btnRegister.setOnClickListener{
            try {
                val nombre: String = binding.Username.text.toString()
                val clave: String = binding.Clave.text.toString()
                val repetirclave : String = binding.RepetirClave.text.toString()

                if (nombre.isNotEmpty() && clave.isNotEmpty() && repetirclave.isNotEmpty()){
                    val intent= Intent(this, VistaBienvenida::class.java)
                    intent.putExtra("nombre",nombre)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Faltan campos por llenar",Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, "Error: ${e.message}",Toast.LENGTH_SHORT).show()
            }
        }

    }
}