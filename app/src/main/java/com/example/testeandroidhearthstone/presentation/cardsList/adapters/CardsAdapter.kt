package com.example.testeandroidhearthstone.presentation.cardsList.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.R.drawable.ic_baseline_error_24
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
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

        holder.imageView.updateLayoutParams {height = (this.width * 1.5/1f).toInt()  }

        Glide
            .with(mContext)
            .load(card.img)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(ic_baseline_error_24)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()
            .priority(Priority.HIGH)
            .listener(object :RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("cardsNotLoaded",card.cardId)
                    holder.imageView.visibility = View.GONE
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.imageView.setImageDrawable(resource)
                    return true
                }
            })
            .into(holder.imageView)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.img_card
    }
}