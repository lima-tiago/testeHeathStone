package com.example.testeandroidhearthstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testeandroidhearthstone.data.ParentModel
import com.example.testeandroidhearthstone.factory.ParentDataFactory
import com.example.testeandroidhearthstone.network.response.InfoResponse
import com.example.testeandroidhearthstone.presentation.HomeContract
import com.example.testeandroidhearthstone.presentation.HomePresenter
import com.example.testeandroidhearthstone.presentation.adapters.ChildAdapter
import com.example.testeandroidhearthstone.presentation.adapters.ParentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() , HomeContract.HomeView {

    lateinit var recyclerView: RecyclerView
    private lateinit var mPresenter: HomeContract.HomePresenter
    private lateinit var mPropertyAdapter:ParentAdapter
    private lateinit var mChildAdapter:ChildAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HomePresenter(this)
        mPresenter.getApiInfo()
    }

    override fun setUpPropertyAdapter(resultInfo: InfoResponse) {
        recyclerView = recycler_property
        mLinearLayoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)
        mPropertyAdapter = ParentAdapter(this,mPresenter.setUpChildAdapterData(resultInfo))

        recyclerView.apply {
            layoutManager = mLinearLayoutManager
            adapter = mPropertyAdapter
        }
    }

    override fun setPresenter(presenter: HomeContract.HomePresenter) {
        this.mPresenter = presenter
    }
}
