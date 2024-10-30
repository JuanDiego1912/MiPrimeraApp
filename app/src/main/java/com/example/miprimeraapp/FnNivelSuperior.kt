package com.example.miprimeraapp

// FUNCIONES DE NIVEL SUPERIOR (ALTO NIVEL)
fun calcular(num1: Int,
             num2: Int,
             fn : (Int, Int) -> Int) : Int {
    return fn(num1, num2)
}