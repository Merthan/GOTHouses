package com.gmail.me2development.gothouses

import retrofit2.Call
import retrofit2.http.GET

interface GotApi {

    @GET("houses")
    fun getHouses(): Call<List<HouseJsonModel>>
}