package com.example.retrofitmvp.interfaces

import Country

interface CountryInterface {
    interface CountryModel{
        fun getCountryInfoByName(countryName:String, presenter: CountryPresenter)
        fun getCountry():Country
    }

    interface CountryView{
        fun updateViewData()
    }

    interface CountryPresenter{
        fun networkcall(countryName: String)
        fun showCountryInfo(): Country
        fun UIAutoUpdate()
    }
}