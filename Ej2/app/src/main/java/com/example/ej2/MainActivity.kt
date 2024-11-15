package com.example.ej2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lista de elementos solares
        val solarList = mutableListOf(
            SolarItem("Corona solar", R.drawable.corona_solar),
            SolarItem("Erupción solar", R.drawable.erupcionsolar),
            SolarItem("Espículas", R.drawable.espiculas),
            SolarItem("Filamentos", R.drawable.filamentos),
            SolarItem("Magnetosfera", R.drawable.magnetosfera),
            SolarItem("Mancha solar", R.drawable.manchasolar)
        )

        // Configurar el RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columnas
        recyclerView.adapter = SolarAdapter(solarList)

        val toolbar = findViewById<Toolbar>(R.id.tbMain)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.comparadorPlanetas -> {
                    val intent = Intent(this, CompararPlanetasActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }

    // Inflar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_comparar_planetas, menu)  // Referencia al archivo correcto
        return true
    }



}
