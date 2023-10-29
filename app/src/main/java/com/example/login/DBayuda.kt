package com.example.login

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBayuda(context: Context):SQLiteOpenHelper(context, "DatosUsuario", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table DatosUsurio(usuario TEXT primary key, contrasena TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists DatosUsuario")
    }
    fun insertardatos(usuario:String, contrasena:String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("usuario", usuario)
        cv. put("contrasena", contrasena)
        val result = p0.insert("DatosUsuario", null, cv)
        if (result==-1.toLong()){
            return false
        }
        return true
    }

    fun check(usuario: String, contrasena: String): Boolean {
        val p0 = this.writableDatabase
        val query = "select * from DatosUsuario where usuario= '$usuario' and contrasena= '$contrasena'"
        val cr = p0.rawQuery(query, null)
        if (cr.count<=0){
            cr.close()
            return false
        }
        cr.close()
        return true
    }
}