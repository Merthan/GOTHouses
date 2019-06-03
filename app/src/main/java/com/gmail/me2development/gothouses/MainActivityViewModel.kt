package com.gmail.me2development.gothouses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel:ViewModel() {



    private val houses: MutableLiveData<List<HouseJsonModel>> by lazy {
        MutableLiveData<List<HouseJsonModel>>().also {
            loadHouses()
        }
    }

    fun getHouses(): LiveData<List<HouseJsonModel>> =houses


    private fun loadHouses(){

        val retrofit= Retrofit.Builder()
            .baseUrl(GOT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gotApi=retrofit.create(GotApi::class.java)

        val call=gotApi.getHouses()
        call.enqueue(object: Callback<List<HouseJsonModel>> {
            override fun onFailure(call: Call<List<HouseJsonModel>>, t: Throwable) {
                Log.e("Error fetching houses",t.toString())
            }

            override fun onResponse(call: Call<List<HouseJsonModel>>, response: Response<List<HouseJsonModel>>) {
                //Set to result, if result is null, set to empty list instead to keep non-nullable
                houses.value=response.body()?: emptyList()
            }

        })
    }

}