package com.example.retrofitmvp

import Country
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.retrofitmvp.databinding.ActivityMainBinding
import com.example.retrofitmvp.interfaces.CountryInterface
import com.example.retrofitmvp.presenter.CountryPresenter
import java.time.Duration

class MainActivity : AppCompatActivity(), CountryInterface.CountryView {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var countryName: String? = null
    private var presenter: CountryPresenter? = null
    private var countryInfo: Country? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = CountryPresenter(this)

        binding.apply {
            tvTitle1.isVisible = false
            tvTitle2.isVisible = false
            tvTitle3.isVisible = false
            tvTitle4.isVisible = false
        }

        binding.btnFindCountry.setOnClickListener {
            countryName = binding.edtCapital.text!!.toString()
            presenter?.networkcall(countryName!!)
        }
    }

    override fun showData() {
        countryInfo = presenter?.getCountryInfo()
        binding.apply {
            tvTitle1.isVisible = true
            tvTitle2.isVisible = true
            tvTitle3.isVisible = true
            tvTitle4.isVisible = true
        }
        countryInfo?.let {
            Glide.with(this).load(it.flags?.png).placeholder(R.drawable.loading).error(R.drawable.image_error).into(binding.countryFlag)
            binding.tvCapital.text = it.capital
            binding.tvRegion.text = it.region
            binding.tvPopulation.text = it.population.toString()
            binding.tvArea.text = it.area.toString() + " km²"
        }
    }

    override fun showErrorMess(errorMess: String) {
        Toast.makeText(this, errorMess, Toast.LENGTH_LONG).show()
    }
}