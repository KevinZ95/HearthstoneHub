package com.example.hearthstonehub


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso



class CardAdapter (val cards:List<CardsInfo>): RecyclerView.Adapter<CardAdapter.cardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_card, parent, false)
        return cardViewHolder(view)
    }


    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        val currentCardsInfo = cards[position]

        holder.name.text = currentCardsInfo.cardName
        holder.mana_cost.text = "Mana: " + currentCardsInfo.manaCost
        holder.health.text = "health: " + currentCardsInfo.health
        holder.attatck.text = "attack: " + currentCardsInfo.attack

        holder.flavorText.text = currentCardsInfo.flavorText



        Picasso
            .get()
            .load(currentCardsInfo.image)
            .into(holder.icon)

    }

    class cardViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val icon: ImageView = view.findViewById(R.id.spell_icon)
        val name: TextView = view.findViewById(R.id.spell_name)
        val mana_cost: TextView = view.findViewById(R.id.spell_mana_cost)
        val health: TextView = view.findViewById(R.id.health)
        val attatck: TextView = view.findViewById(R.id.attack)
        //val description: TextView = view.findViewById(R.id.card_description)
        val flavorText: TextView = view.findViewById(R.id.spell_flavorText)
    }


}