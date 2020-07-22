package com.example.testeandroidhearthstone.presentation.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.data.model.HomeInfo
import kotlinx.android.synthetic.main.home_recycler_item.view.*
import java.util.*

class ItemsAdapter(
    private val children: HomeInfo,
    private val adapterOnClick: AdapterOnClick
) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_item, parent, false)
        return ViewHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return children.values.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val child = children.values[position]
        holder.card.setBackgroundColor(getRandomColor())
        holder.textView.text = child
        holder.card.setOnClickListener {
            adapterOnClick.onClick(children.property,child)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: ConstraintLayout = itemView.child_card
        val textView: TextView = itemView.child_textView
    }

    private fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255))
    }

}