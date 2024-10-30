package com.example.miprimeraapp

import android.app.Activity
import android.widget.Toast

// FUNCIONES DE EXTENSIÓN
fun String.sinEspacios() : String {
    return this.replace(" ", "")
}

// Igual que "hola".repeat(6) pero ahora 6.repeat("hola")
fun Int.repeat(cadena : String) = cadena.repeat(this)

// Devuelvo el contrario del valor Boolean actual
fun Boolean.contrario() = !this

// Identifica si cualquier objeto que hereda de Any es null o no
fun Any?.isNull() : Boolean = this == null

fun Activity.toast(texto : String, duracion : Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,
        texto,
        duracion)
        .show()
}

fun sumar(a : Int, b : Int) = a + b