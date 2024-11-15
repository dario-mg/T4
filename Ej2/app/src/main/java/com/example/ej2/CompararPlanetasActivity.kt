package com.example.ej2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CompararPlanetasActivity : AppCompatActivity() {

    // Definición de los elementos de la UI
    private lateinit var autoCompleteTextView1: AutoCompleteTextView
    private lateinit var autoCompleteTextView2: AutoCompleteTextView
    private lateinit var diametro1: TextView
    private lateinit var diametro2: TextView
    private lateinit var distancia1: TextView
    private lateinit var distancia2: TextView
    private lateinit var densidad1: TextView
    private lateinit var densidad2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comparar_planetas)  // Asegúrate de que el nombre del layout sea correcto

        // Inicializamos las vistas
        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView)
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView2)
        diametro1 = findViewById(R.id.textView4)
        diametro2 = findViewById(R.id.textView5)
        distancia1 = findViewById(R.id.textView10)
        distancia2 = findViewById(R.id.textView11)
        densidad1 = findViewById(R.id.textView14)
        densidad2 = findViewById(R.id.textView15)

        // Lista de planetas
        val listaPlanetas = arrayListOf(
            Planeta("Mercurio", 0.382, 0.387, 5400),
            Planeta("Venus", 0.949, 0.723, 5250),
            Planeta("Tierra", 1.0, 1.0, 5520),
            Planeta("Marte", 0.53, 1.542, 3960),
            Planeta("Júpiter", 11.2, 5.203, 1350),
            Planeta("Saturno", 9.41, 9.539, 700),
            Planeta("Urano", 3.38, 19.81, 1200),
            Planeta("Neptuno", 3.81, 30.07, 1500),
            Planeta("Plutón", 0.0, 39.44, 5)  // Plutón con datos incompletos
        )

        // Crear el adaptador
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listaPlanetas)

        // Establecer el adaptador en ambos AutoCompleteTextView
        autoCompleteTextView1.setAdapter(adapter)
        autoCompleteTextView2.setAdapter(adapter)

        // Establecer los listeners para detectar la selección de un planeta
        autoCompleteTextView1.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            diametro1.text = planetaSeleccionado.diametro.toString()
            distancia1.text = planetaSeleccionado.distanciaAlSol.toString()
            densidad1.text = planetaSeleccionado.densidad.toString()
        }

        autoCompleteTextView2.setOnItemClickListener { parent, view, position, id ->
            val planetaSeleccionado = parent.getItemAtPosition(position) as Planeta
            diametro2.text = planetaSeleccionado.diametro.toString()
            distancia2.text = planetaSeleccionado.distanciaAlSol.toString()
            densidad2.text = planetaSeleccionado.densidad.toString()
        }
    }
}


