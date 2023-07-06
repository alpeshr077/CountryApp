package com.example.countryapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("all")
    fun getcountrty():Call<List<CountryModel>>

}