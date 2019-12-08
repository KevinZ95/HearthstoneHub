package com.example.hearthstonehub



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SpellAdapter (val cards:List<CardsInfo>): RecyclerView.Adapter<SpellAdapter.spellViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellAdapter.spellViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.spell_card, parent, false)
        return spellViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: SpellAdapter.spellViewHolder, position: Int) {
        val currentCardsInfo = cards[position]

        holder.name.text = currentCardsInfo.cardName
        holder.mana_cost.text = "Mana: " + currentCardsInfo.manaCost
        holder.flavorText.text = currentCardsInfo.flavorText

        Picasso
            .get()
            .load(currentCardsInfo.image)
            .into(holder.icon)
    }


    class spellViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val icon: ImageView = view.findViewById(R.id.spell_icon)
        val name: TextView = view.findViewById(R.id.spell_name)
        val mana_cost: TextView = view.findViewById(R.id.spell_mana_cost)
        val flavorText: TextView = view.findViewById(R.id.spell_flavorText)
    }

}