package com.example.testeandroidhearthstone.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HomeInfo
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.presentation.cardsList.CardsActivityList
import com.example.testeandroidhearthstone.presentation.home.adapter.AdapterOnClick
import com.example.testeandroidhearthstone.presentation.home.adapter.PropertiesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), HomeContract.HomeView , AdapterOnClick{

    private val mPresenter: HomeContract.HomePresenter by inject { parametersOf(this) }

    private lateinit var recyclerView: RecyclerView
    private lateinit var mPropertyAdapter: PropertiesAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.getApiInfo()
    }

    override fun setUpPropertyAdapter(homeInfoList: List<HomeInfo>) {
        recyclerView = recycler_property
        mLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mPropertyAdapter =
            PropertiesAdapter(
                this,
                homeInfoList,
                this
            )

        recyclerView.apply {
            layoutManager = mLinearLayoutManager
            adapter = mPropertyAdapter
        }
    }

    override fun onClick(property: String, param: String) {
        val i = Intent(this, CardsActivityList::class.java)
        i.putExtra("property",property)
        i.putExtra("param",param)
        startActivity(i)
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
