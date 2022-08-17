package com.example.retrofitmvp.interfaces

import Country

interface CountryInterface {
    interface CountryModel {
        fun getCountryByNameFromAPI(countryName: String, presenter: CountryPresenter)
        fun getCountry(): Country
    }

    interface CountryView {
        fun showData()
        fun showErrorMess(errorMess: String)
    }

    interface CountryPresenter {
        fun networkcall(countryName: String)
        fun getCountryInfo(): Country
        fun UIAutoUpdate()
        fun failToExecute(errorMess: String)
    }
}