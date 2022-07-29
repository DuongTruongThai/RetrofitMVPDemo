package com.example.retrofitmvp.model.repos

import Country
import android.util.Log
import com.example.retrofitmvp.interfaces.CountryInterface
import com.example.retrofitmvp.model.api.JobAPI
import com.example.retrofitmvp.model.api.JobServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepos:CountryInterface.CountryModel {

    private lateinit var country:Country
    private var apiClient: JobServices?=null

    init {
        apiClient = JobAPI.client.create(JobServices::class.java)
    }

    override fun getCountryInfoByName(
        countryName: String,
        presenter: CountryInterface.CountryPresenter
    ) {
        val call = apiClient?.getCountryByName(countryName)
        call?.enqueue(object : Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful){
                    country = response.body()?.get(0)!!
                    presenter.UIAutoUpdate()
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d("error",t.toString())
            }

        })
    }

    override fun getCountry(): Country {
        return country
    }
}