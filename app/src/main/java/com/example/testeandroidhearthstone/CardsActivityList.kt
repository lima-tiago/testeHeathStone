package com.example.testeandroidhearthstone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.testeandroidhearthstone.data.repository.CardsRepository
import com.example.testeandroidhearthstone.data.repository.ICardsRepository
import com.example.testeandroidhearthstone.data.repository.SharedPreferences
import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.CardResponse
import com.example.testeandroidhearthstone.presentation.CardsListContract
import com.example.testeandroidhearthstone.presentation.CardsListPresenter
import com.example.testeandroidhearthstone.presentation.adapters.CardsAdapter
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivityList : AppCompatActivity(), CardsListContract.CardsListView {

    lateinit var recyclerView: RecyclerView
    private lateinit var mPresenter: CardsListContract.CardsListPresenter
    private lateinit var mAdapter: CardsAdapter
    private lateinit var mStaggeredGridLayoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        CardsListPresenter(this,SharedPreferences(this),CardsRepository(apiClient = ApiClient))
        btn_back.setOnClickListener {
            this.finish()
        }
        mPresenter.getCards(getIncomingExtraProperty(),getIncomingExtraParam())
    }

    override fun setPresenter(presenter: CardsListContract.CardsListPresenter) {
        mPresenter = presenter
    }

    override fun getIncomingExtraProperty(): String {
        return intent.getStringExtra("property")
    }

    override fun getIncomingExtraParam(): String {
        return intent.getStringExtra("param")
    }

    override fun setUpAdapter(cards: List<CardResponse>) {
        recyclerView = recycler_cards
        mStaggeredGridLayoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        mAdapter = CardsAdapter(this,cards)

        recyclerView.apply {
            layoutManager = mStaggeredGridLayoutManager
            adapter = mAdapter
        }
    }
}
