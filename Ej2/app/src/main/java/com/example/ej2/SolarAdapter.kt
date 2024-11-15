package com.example.ej2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class SolarAdapter(
    private val solarList: MutableList<SolarItem>
) : RecyclerView.Adapter<SolarAdapter.SolarViewHolder>() {

    inner class SolarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSolar: ImageView = itemView.findViewById(R.id.imageViewSolar)
        val toolbarSolar: Toolbar = itemView.findViewById(R.id.toolbarSolar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val solarItem = solarList[position]

        // Configurar la imagen y el título del Toolbar
        holder.imageViewSolar.setImageResource(solarItem.imageResId)
        holder.toolbarSolar.title = solarItem.name

        // Configurar el menú Overflow con programación funcional
        holder.toolbarSolar.inflateMenu(R.menu.menu_solar_item)
        holder.toolbarSolar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_copy -> {
                    val copiedItem = SolarItem(solarItem.name + " (Copia)", solarItem.imageResId)
                    solarList.add(position + 1, copiedItem)
                    notifyItemInserted(position + 1)
                    true
                }
                R.id.action_delete -> {
                    solarList.removeAt(position)
                    notifyItemRemoved(position)
                    true
                } else -> false
            }
        }
    }

    override fun getItemCount(): Int = solarList.size
}
