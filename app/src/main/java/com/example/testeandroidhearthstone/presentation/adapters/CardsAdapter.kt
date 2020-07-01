package com.example.testeandroidhearthstone.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.network.response.Card_Entity
import kotlinx.android.synthetic.main.card_item.view.*


class CardsAdapter(private val mContext: Context, private val cards: List<Card_Entity>) :
    RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val card = cards[position]

        Glide
            .with(mContext)
            .load("https://art.hearthstonejson.com/v1/render/latest/${card.locale}/512x/${card.cardId}.png")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.img_card
    }
}