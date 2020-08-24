package com.example.testeandroidhearthstone.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidhearthstone.R
import com.example.domain.model.HomeInfo
import kotlinx.android.synthetic.main.home_recycler_properties.view.*

class PropertiesAdapter(
    private val mContext: Context,
    private val homeInfoList: List<HomeInfo>,
    private val adapterOnClick: AdapterOnClick
) :
    RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_recycler_properties, parent, false)
        return ViewHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return homeInfoList.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.textView.text = homeInfoList[position].property
        val itemsLayoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
        itemsLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = itemsLayoutManager
            adapter =
                ItemsAdapter(
                    homeInfoList[position],
                    adapterOnClick
                )
            setRecycledViewPool(viewPool)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.recycler_child
        val textView: TextView = itemView.parent_recycler_textView
    }
}