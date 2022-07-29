package com.example.retrofitmvp

import Country
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.retrofitmvp.databinding.ActivityMainBinding
import com.example.retrofitmvp.interfaces.CountryInterface
import com.example.retrofitmvp.presenter.CountryPresenter

class MainActivity : AppCompatActivity(), CountryInterface.CountryView {

    private lateinit var binding: ActivityMainBinding
    private var countryName: String ?= null
    private var presenter: CountryPresenter ?= null
    private var contryInfo: Country ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = CountryPresenter(this)

        binding.tvTitle1.setVisibility(View.INVISIBLE)
        binding.tvTitle2.setVisibility(View.INVISIBLE)
        binding.tvTitle3.setVisibility(View.INVISIBLE)
        binding.tvTitle4.setVisibility(View.INVISIBLE)

        binding.btnFindCountry.setOnClickListener {
            countryName = binding.edtCapital.text!!.toString()
            presenter?.networkcall(countryName!!)
        }
    }

    override fun updateViewData() {
        contryInfo = presenter?.showCountryInfo()
        if (contryInfo != null) {
            binding.tvTitle1.setVisibility(View.VISIBLE)
            binding.tvTitle2.setVisibility(View.VISIBLE)
            binding.tvTitle3.setVisibility(View.VISIBLE)
            binding.tvTitle4.setVisibility(View.VISIBLE)
            Glide.with(this).load(contryInfo!!.flags.png).placeholder(R.drawable.loading).error(R.drawable.image_error).into(binding.countryFlag)
            binding.tvCapital.text = contryInfo!!.capital
            binding.tvRegion.text = contryInfo!!.region
            binding.tvPopulation.text = contryInfo!!.population.toString()
            binding.tvArea.text = contryInfo!!.area.toString() + " km²"
        }
    }
}