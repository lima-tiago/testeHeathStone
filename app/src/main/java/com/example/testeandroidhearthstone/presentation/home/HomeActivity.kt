package com.example.testeandroidhearthstone.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.data.model.HomeInfo
import com.example.testeandroidhearthstone.presentation.cardsList.CardsActivityList
import com.example.testeandroidhearthstone.presentation.home.adapter.ParentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), HomeContract.HomeView {

    private val mPresenter: HomeContract.HomePresenter by inject { parametersOf(this) }

    lateinit var recyclerView: RecyclerView
    private lateinit var mPropertyAdapter: ParentAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.getApiInfo()
    }

    override fun setUpPropertyAdapter(resultInfo: List<HomeInfo>) {
        recyclerView = recycler_property
        mLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mPropertyAdapter =
            ParentAdapter(
                this,
                resultInfo
            )

        recyclerView.apply {
            layoutManager = mLinearLayoutManager
            adapter = mPropertyAdapter
        }
    }

    override fun startShimmer() {
        shimmerLayout.startShimmer()
        shimmerLayout.visibility = View.VISIBLE
    }

    override fun stopShimmer() {
        shimmerLayout.stopShimmer()
        shimmerLayout.visibility = View.GONE
    }
}
