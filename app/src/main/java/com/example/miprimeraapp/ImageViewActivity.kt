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

        tvFecha.text = calcular(4,
            5,
            ::sumar).toString()

        // Trabajamos con dos datos de tipo Int y devolvemos un Int. Hacemos una resta
        val resta : (Int, Int) -> Int = { num1, num2 -> num1 - num2 }

        tvFecha.text = calcular(10,
            5
        ) { num1, num2 ->
            num1 - num2 }
            .toString()

        var array : Array<Int> = arrayOf(1, 2, 3, 4)
        var arrayEnteros = IntArray(4) { 4 }

        tvFecha.text = arrayEnteros.joinToString()

        setArray(arrayEnteros) {  it * 2 }

    }

    fun setArray(array : IntArray, fn : (Int) -> Int ) {
        for (indice in 0..array.size) {
            array[indice] = fn(indice)
        }
    }

}