package com.example.miprimeraapp

import android.os.Bundle
import android.widget.ImageView
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

        /* Importar una imagen desde internet
        val ivDarthVaderRemoto = findViewById<ImageView>(R.id.darthVaderRemoto)
        Picasso.get().load("https://noticiasnet1.cdn.net.ar/252/noticiasnet/images/01/15/79/1157976_62297041261ee982190437e0236913c7eb44ca5ed97e5c4d9daf0acc372be261/lg.jpg")
            .into(ivDarthVaderRemoto)*/

    }
}