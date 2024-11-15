
package com.example.ej1

import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var imageSwitcher: ImageSwitcher
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSwitcher = findViewById(R.id.imageSwitcher)
        recyclerView = findViewById(R.id.recyclerView)

        // Configura el ImageSwitcher con un ViewFactory
        imageSwitcher.setFactory(ViewSwitcher.ViewFactory {
            ImageView(applicationContext).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }
        })

        // Lista de imágenes para el RecyclerView (usa tus propios recursos de imagen)
        val imageList = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10 // Añade más imágenes aquí
        )

        // Configura el RecyclerView con un LayoutManager horizontal
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Configura el adaptador y asigna la lista de imágenes
        val adapter = ImageAdapter(imageList)
        recyclerView.adapter = adapter
    }
}
