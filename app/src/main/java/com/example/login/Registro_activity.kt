package com.example.login

import android.content.Intent
import android.graphics.PointF
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private lateinit var usuario: EditText
private lateinit var contrasena: EditText
private lateinit var confcontrasena: EditText
private lateinit var registro: Button
private lateinit var bd: DBayuda

class Registro_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        usuario = findViewById(R.id.registro_usuario)
        contrasena = findViewById(R.id.registro_contrasena)
        confcontrasena = findViewById(R.id.confcontrasena)
        registro = findViewById(R.id.btnregistro)
        bd = DBayuda(this)

        registro.setOnClickListener{
            val usuariotext = usuario.text.toString()
            val contrasenatext = contrasena.text.toString()
            val conftext = confcontrasena.text.toString()
            val guardar = bd.insertardatos(usuariotext, contrasenatext)

            if(TextUtils.isEmpty(usuariotext) || TextUtils.isEmpty(contrasenatext) || TextUtils.isEmpty(conftext)){
                Toast.makeText(this, "Los campos se encuentran vacios", Toast.LENGTH_SHORT).show()
            }else{
                if(usuariotext.length<8){
                    Toast.makeText(this, "El usuario contiene menos de 8 caracteres", Toast.LENGTH_SHORT).show()
                }else if(contrasenatext.length<6){
                    Toast.makeText(this, "La contraseña contiene menos de 6 caracteres", Toast.LENGTH_SHORT).show()
                }
            }
            if (contrasenatext.equals(conftext)){
                if (guardar==true){
                    Toast.makeText(this, "Registro correctamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}