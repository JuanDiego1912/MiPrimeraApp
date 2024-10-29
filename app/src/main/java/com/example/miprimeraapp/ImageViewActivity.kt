package com.example.miprimeraapp

import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Importar una imagen desde internet*/
        val ivDarthVaderRemoto = findViewById<ImageView>(R.id.darthVaderRemoto)
        Picasso.get().load("https://noticiasnet1.cdn.net.ar/252/noticiasnet/images/01/15/79/1157976_62297041261ee982190437e0236913c7eb44ca5ed97e5c4d9daf0acc372be261/lg.jpg")
            .into(ivDarthVaderRemoto)

        val cvCalendario = findViewById<CalendarView>(R.id.cvCalendario)
        val tvFecha = findViewById<TextView>(R.id.tvFecha)

        cvCalendario.setOnDateChangeListener { cv, year, month, day ->
            tvFecha.text = "Fecha: $day/${month + 1}/$year"
        }

        tvFecha.text = calcular(4,5,::sumar).toString()



    }

    // FUNCIONES DE EXTENSIÓN
    fun String.sinEspacios() : String {
        return this.replace(" ", "")
    }

    // Igual que "hola".repeat(6) pero ahora 6.repeat("hola")
    fun Int.repeat(cadena : String) = cadena.repeat(this)

    // Devuelvo el contrario del valor Boolean actual
    fun Boolean.contrario() = !this

    // FUNCIONES DE NIVEL SUPERIOR (ALTO NIVEL)
    fun calcular(num1: Int,
                 num2: Int,
                 fn : (Int, Int) -> Int) : Int {
        return fn(num1, num2)
    }

    fun sumar(a : Int, b : Int) = a + b


}