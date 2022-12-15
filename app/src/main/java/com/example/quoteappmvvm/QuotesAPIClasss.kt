package com.example.quoteappmvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotesAPIClass {

    private lateinit var retrofit: Retrofit

    fun getClient() : Retrofit {
        retrofit = Retrofit
            .Builder()
            .baseUrl("https://type.fit/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}