package com.example.ej3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.ej3.R

class CardAdapter(private val cardList: List<CardData>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // ViewHolder para cada tarjeta
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageCard: ImageView = view.findViewById(R.id.imageCard)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val ratingBarSmall: RatingBar = view.findViewById(R.id.ratingBarSmall)
        val ratingTextView: TextView = view.findViewById(R.id.ratingTextView)
        val locationTextView: TextView = view.findViewById(R.id.locationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_postre, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cardList[position]

        // Configurar los datos de la tarjeta
        holder.imageCard.setImageResource(card.imageRes)
        holder.titleTextView.text = card.title
        holder.locationTextView.text = card.location
        holder.ratingBarSmall.rating = card.rating

        // Cambiar el texto al mover el RatingBar
        holder.ratingBarSmall.setOnRatingBarChangeListener { _, rating, _ ->
            card.rating = rating
            holder.ratingTextView.text = rating.toString()
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}
