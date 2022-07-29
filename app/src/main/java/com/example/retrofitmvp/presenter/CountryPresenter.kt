package com.example.retrofitmvp.presenter

import Country
import com.example.retrofitmvp.interfaces.CountryInterface
import com.example.retrofitmvp.model.repos.CountryRepos

class CountryPresenter(countryView: CountryInterface.CountryView): CountryInterface.CountryPresenter {

    private var view: CountryInterface.CountryView = countryView
    private var model: CountryInterface.CountryModel = CountryRepos()

    override fun networkcall(countryName: String) {
        model?.getCountryInfoByName(countryName, this)
    }

    override fun showCountryInfo(): Country {
        return model.getCountry()
    }

    override fun UIAutoUpdate() {
        view.updateViewData()
    }
}