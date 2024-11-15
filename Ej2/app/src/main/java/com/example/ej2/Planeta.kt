package com.example.ej2

// Clase para representar un Planeta
data class Planeta(
    val nombre: String,
    val diametro: Double,
    val distanciaAlSol: Double,
    val densidad: Int
) {
    override fun toString(): String {
        return nombre  // Solo mostramos el nombre del planeta en el AutoCompleteTextView
    }
}