package com.example.testeandroidhearthstone.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class CardsPaginator(
    recyclerView: RecyclerView,
    private val isLoading:Boolean,
    private val needCards:Boolean

) :RecyclerView.OnScrollListener(){
    var currentPage:Int = 1

    private var mlayoutManager:StaggeredGridLayoutManager

    init {
        recyclerView.addOnScrollListener(this)
        mlayoutManager = recyclerView.layoutManager as StaggeredGridLayoutManager
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount =mlayoutManager.childCount
        val totalItemCount = mlayoutManager.itemCount
        val firstVisibleItemPosition = mlayoutManager.findFirstVisibleItemPositions().

        if (!needCards) return

        if (!isLoading){
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount)
        }
    }
}