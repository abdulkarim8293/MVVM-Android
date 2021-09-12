package com.example.mvvm_android.adaptar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_android.OnItemClickListener
import com.example.mvvm_android.R
import com.example.mvvm_android.network.data.PokemonResponse
import com.example.mvvm_android.room_database.User
import com.example.mvvm_android.to_do_list.ToDoData

class GetPokemonAdapter(private val pokemonResponse:List<PokemonResponse>)  : RecyclerView.Adapter<GetPokemonAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_get_pokemon, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pokemonResponse = pokemonResponse.get(position)
        holder.name.text = "${pokemonResponse.name}"
        holder.ability.text =  "Name is : ${pokemonResponse.abilities.get(0).ability.name}\nUrl is :${pokemonResponse.abilities.get(0).ability.url}"
        holder.species.text = "Species name is :${pokemonResponse.species.name}"

    }

    override fun getItemCount(): Int {
        return pokemonResponse.size
    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val  name:TextView = itemView.findViewById(R.id.nameTv)
        val  ability:TextView = itemView.findViewById(R.id.abilityTv)
        val  species:TextView = itemView.findViewById(R.id.speciesTv)
    }

}