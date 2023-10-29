package com.example.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var registro: Button
    private lateinit var inicio: Button
    private lateinit var editar: EditText
    private lateinit var edicon: EditText
    private lateinit var bda: DBayuda

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registro = findViewById(R.id.btnregistro)
        inicio=findViewById(R.id.btninicio)
        editar= findViewById(R.id.iniciousuario)
        edicon= findViewById(R.id.inicicontra)


        val registro=findViewById<Button>(R.id.btnregistro)
        registro.setOnClickListener {
            val ver = Intent(this, Registro_activity::class.java)
            startActivity(ver)
        }

        val inicio=findViewById<Button>(R.id.btninicio)
        inicio.setOnClickListener {
            val ver = Intent(this, inicio_activity::class.java)
            startActivity(ver)
        }

        val usuario = editar.text.toString()
        val contrasena = edicon.text.toString()

        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
        }
        else{
            val validar = bda.check(usuario, contrasena)
            if (validar==true){
                Toast.makeText(this, "Inicio Correctamente", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}