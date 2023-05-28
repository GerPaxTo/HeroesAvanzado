package com.gerpax.heroesavanzado.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gerpax.heroesavanzado.R
import com.gerpax.heroesavanzado.ui.models.Hero
import com.squareup.picasso.Picasso

class HeroeListaAdapter(private val onClick: (String) -> (Unit)) :
    ListAdapter<Hero, HeroeListaAdapter.SuperheroViewHolder>(SuperheroDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val superheroName = itemView.findViewById<TextView>(R.id.tvNombre)
        private val superheroPhoto = itemView.findViewById<ImageView>(R.id.imageHero)
        private val superheroDesc = itemView.findViewById<TextView>(R.id.heroDesc)
        private val superheroFav = itemView.findViewById<ImageView>(R.id.imageFav)

        private lateinit var superhero: Hero

        init {
            itemView.setOnClickListener {
                onClick(superhero.id)
            }
        }

        fun bind(superhero: Hero) {
            this.superhero = superhero
            superheroName.text = superhero.name
            superheroDesc.text = superhero.description
            Picasso.get().load(superhero.photo).into(superheroPhoto)
            superheroFav.isVisible = superhero.favorite
        }
    }

    class SuperheroDiffCallback: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }

    }
}