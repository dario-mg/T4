package com.example.ej3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración del Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
        setSupportActionBar(toolbar)

        // Configuración del RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCards)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardAdapter(getSampleData())
    }

    private fun getSampleData(): List<CardData> {
        return listOf(
            CardData(R.drawable.images, "Ático elegante", "Madrid", 0f),
            CardData(R.drawable.images1, "Casa moderna", "Barcelona", 0f),
            CardData(R.drawable.images2, "Villa rústica", "Valencia", 0f),
            CardData(R.drawable.images3, "Apartamento acogedor", "Sevilla", 0f),
            CardData(R.drawable.images4, "Casa de lujo", "Bilbao", 0f),
            CardData(R.drawable.images5, "Estudio urbano", "Granada", 0f),
            CardData(R.drawable.images6, "Dúplex moderno", "Málaga", 0f)
        )
    }
}
