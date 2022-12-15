package com.example.quoteappmvvm

import retrofit2.Call
import retrofit2.http.GET

interface QuotesLearningAPIInterface {

    @GET("quotes")
    fun getQuotes(): Call<List<QuotesLearningResponseModelItem?>?>
}