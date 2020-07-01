package com.example.testeandroidhearthstone.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.data.model.ParentModel
import kotlinx.android.synthetic.main.recycler_child.view.*

class ParentAdapter(private val mContext: Context, private val properties: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_child, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.textView.text = properties[position].title
        val childLayoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(mContext,properties[position].children,properties[position].title)
            setRecycledViewPool(viewPool)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.recycler_child
        val textView: TextView = itemView.parent_recycler_textView
    }
}