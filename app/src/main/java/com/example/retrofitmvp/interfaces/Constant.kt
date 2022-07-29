package com.example.retrofitmvp.interfaces

interface Constant {
    companion object{
        const val BASE_URL = "https://restcountries.com/"
        const val CountryName = "/v2/name/{name}"
    }
}