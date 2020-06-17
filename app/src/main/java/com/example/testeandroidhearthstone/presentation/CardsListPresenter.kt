package com.example.testeandroidhearthstone.presentation

import com.example.testeandroidhearthstone.network.ApiClient
import com.example.testeandroidhearthstone.network.response.CardImageResponse
import com.example.testeandroidhearthstone.network.response.CardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardsListPresenter(private val view: CardsListContract.CardsListView) :
    CardsListContract.CardsListPresenter {

    init {
        this.view.setPresenter(this)
    }

    override fun start() {}

    override fun getCards(property: String, param: String) {
        val call = getCallType(property, param)

        call?.enqueue(object : Callback<List<CardResponse>> {
            override fun onResponse(call: Call<List<CardResponse>>, response: Response<List<CardResponse>>) {
                var resultCards = response.body()!!
                view.setUpAdapter(resultCards)
            }

            override fun onFailure(call: Call<List<CardResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    override fun getCallType(property: String, param: String): Call<List<CardResponse>>? {
        return when (property) {
            "Sets" -> ApiClient.getClient().getCardsBySet(param)
            "Classes" -> ApiClient.getClient().getCardsByClass(param)
            "Races" -> ApiClient.getClient().getCardsByRaces(param)
            "Qualities" -> ApiClient.getClient().getCardsByQualities(param)
            "Types" -> ApiClient.getClient().getCardsByTypes(param)
            "Factions" -> ApiClient.getClient().getCardsByFactions(param)
            else -> null
        }
    }
}