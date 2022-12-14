package com.example.retrofitmvp.presenter

import Country
import com.example.retrofitmvp.interfaces.CountryInterface
import com.example.retrofitmvp.model.repos.CountryRepos

class CountryPresenter(countryView: CountryInterface.CountryView) :
    CountryInterface.CountryPresenter {

    private var view: CountryInterface.CountryView = countryView
    private var model: CountryInterface.CountryModel = CountryRepos()

    override fun networkcall(countryName: String) {
        model.getCountryByNameFromAPI(countryName, this)
    }

    override fun getCountryInfo(): Country {
        return model.getCountry()
    }

    override fun UIAutoUpdate() {
        view.showData()
    }

    override fun failToExecute(errorMess: String) {
        view.showErrorMess(errorMess)
    }
}