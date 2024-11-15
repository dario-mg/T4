package com.example.ej1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val imageList: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageResource = imageList[position]
        holder.imageView.setImageResource(imageResource)

        holder.itemView.setOnClickListener {
            val imageSwitcher = (it.context as Activity).findViewById<ImageSwitcher>(R.id.imageSwitcher)
            imageSwitcher.setImageResource(imageResource)
        }
    }

    override fun getItemCount(): Int = imageList.size
}
