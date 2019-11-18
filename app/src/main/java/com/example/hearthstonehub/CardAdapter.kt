package com.example.hearthstonehub


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

// Unfinished here

class CardAdapter (val cards:List<CardsInfo>)  : RecyclerView.Adapter<CardAdapter.cardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_yelp, parent, false)
        return yelpViewHolder(view)
    }


    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: yelpViewHolder, position: Int) {
        val currentBusiness = cards[position]

        // need changes here
        holder.name.text = currentBusiness.name
        holder.handle.text = currentBusiness.address
        holder.content.text = currentBusiness.info

        Picasso
            .get()
            .load(currentBusiness.iconUrl)
            .into(holder.icon)


    }

    class yelpViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val icon: ImageView = view.findViewById(R.id.icon)
        val name: TextView = view.findViewById(R.id.username)
        val handle: TextView = view.findViewById(R.id.handle)
        val content: TextView = view.findViewById(R.id.tweet_content)
    }



}