package com.example.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnregistro=findViewById<Button>(R.id.btnregistro)
        btnregistro.setOnClickListener {
            val ver = Intent(this, Registro_activity::class.java)
            startActivity(ver)
        }
    }
}