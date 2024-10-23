package com.example.miprimeraapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ChipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chip)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var cgAvisos = findViewById<ChipGroup>(R.id.cgAvisos);

        for (i in 0..< cgAvisos.childCount) {
            /*Casteo el hijo que he tomado de cgAvisos a Chip
            * porque sino obtendría un objeto View que no me interesa. Cada
            * elemento View se castea a chip y posteriormente uso sus métodos*/
            val chip = cgAvisos.getChildAt(i) as Chip
            chip.isChecked = false

            /* Cada vez que se pulse el aspa de un chip este desaperecera. It
            * se refiere al objeto Chip pulsado*/
            chip.setOnCloseIconClickListener {
                cgAvisos.removeView(it)
            }

            chip.setOnClickListener {
                /* Convierto It que es el chip exterior a esta función en
                * otro chip auxiliar
                * val chipAux = it as Chip
                */

                /* Si it esta marcado entonces se ejecutara*/
                if ((it as Chip).isChecked) {
                    /* Toast sirve para mostrar un pequeño mensaje por pantalla
                    * con la durración, el texto y en el View que
                    * decidamos */
                    Toast.makeText(this,
                        //Casteo it como un objeto Chip y obtengo su texto
                        "Se ha pulsado ${it.text}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}