package com.example.testeandroidhearthstone.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class CardsPaginator(
    recyclerView: RecyclerView,
    private var isLoading: Boolean,
    private val getTenCards: (Int) -> Unit


) : RecyclerView.OnScrollListener() {

    private var mlayoutManager: StaggeredGridLayoutManager

    init {
        recyclerView.addOnScrollListener(this)
        mlayoutManager = recyclerView.layoutManager as StaggeredGridLayoutManager
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = mlayoutManager.childCount
        val totalItemCount = mlayoutManager.itemCount
        val lastVisibleItem = mlayoutManager.findLastVisibleItemPositions(null).last()

        if (lastVisibleItem <= totalItemCount) return

        if (!isLoading) {
            isLoading = true
//            getTenCards(totalItemCount)
        }
    }
}