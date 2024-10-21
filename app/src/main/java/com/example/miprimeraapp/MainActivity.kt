package com.example.miprimeraapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //val TVsaludo : TextView = findViewById(R.id.TVsaludo)
    lateinit var TVsaludo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TVsaludo = findViewById(R.id.TVsaludo)
        println(TVsaludo.text)
        TVsaludo.text = getText(R.string.msgError)
        println(TVsaludo.text)

        /*TVsaludo.setOnClickListener {
            TVsaludo.text = "Me has pulsado!!"
        }*/

        //Parametrizaciñón del código usando los resources String.xml
        var actvProvincias = findViewById<AutoCompleteTextView>(R.id.actvProvincias)

        //Obtengo el string-Array desde los resources
        val provincias = resources.getStringArray(R.array.provincias)
        var adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line,
            provincias)
        actvProvincias.setAdapter(adapter)

    }
}