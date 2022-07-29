package com.example.retrofitmvp.model.api

import Country
import com.example.retrofitmvp.interfaces.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JobServices {

    @GET(Constant.CountryName)
    fun getCountryByName(@Path("name") name:String):Call<List<Country>>
}