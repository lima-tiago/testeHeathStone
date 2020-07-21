package com.example.testeandroidhearthstone.presentation.cardsList

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.testeandroidhearthstone.R
import com.example.testeandroidhearthstone.domain.entities.Card_Entity
import com.example.testeandroidhearthstone.presentation.cardsList.adapters.CardsAdapter
import com.example.testeandroidhearthstone.presentation.cardsList.adapters.CardsPaginator
import kotlinx.android.synthetic.main.activity_cards.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CardsActivityList : AppCompatActivity(), CardsListContract.CardsListView {

    private val mPresenter: CardsListContract.CardsListPresenter by inject { parametersOf(this) }

    lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: CardsAdapter
    private lateinit var mPaginator: CardsPaginator
    private lateinit var mStaggeredGridLayoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        mPresenter.getCards()

        btn_back.setOnClickListener {
            this.finish()
        }
    }

    override fun getIncomingExtraProperty(): String {
        return intent.getStringExtra("property")
    }

    override fun getIncomingExtraParam(): String {
        return intent.getStringExtra("param")
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun setTitle(param: String) {
        titleCards.text = param
    }

    override fun setUpAdapter(cards: List<Card_Entity>) {
        recyclerView = recycler_cards
        mStaggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mStaggeredGridLayoutManager.gapStrategy =
            StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        mAdapter = CardsAdapter(this, cards)

        recyclerView.apply {
            layoutManager = mStaggeredGridLayoutManager
            adapter = mAdapter
            mPaginator = CardsPaginator(
                recyclerView,
                false
            ) { mPresenter.getCardsWithId() }
        }
    }
}
