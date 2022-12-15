package com.example.quoteappmvvm

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuotesLearningNetworkDataSource {

    fun getQuotes(
        data: MutableLiveData<GenericResponse<List<QuotesLearningResponseModelItem?>?>>
    ) = QuotesAPIClass().getClient().create(QuotesLearningAPIInterface::class.java)
        .getQuotes()
        .enqueue(object : Callback<List<QuotesLearningResponseModelItem?>?> {
            override fun onResponse(
                call: Call<List<QuotesLearningResponseModelItem?>?>,
                response: Response<List<QuotesLearningResponseModelItem?>?>
            ) {
                if (response.isSuccessful) {
                    data.value = GenericResponse<List<QuotesLearningResponseModelItem?>?>(
                        response.body(),
                        true,
                        null
                    )
                } else {
                    data.value = GenericResponse<List<QuotesLearningResponseModelItem?>?>(
                        null,
                        false,
                        response.message()
                    )
                }
            }

            override fun onFailure(
                call: Call<List<QuotesLearningResponseModelItem?>?>,
                t: Throwable
            ) {
                data.value = GenericResponse<List<QuotesLearningResponseModelItem?>?>(
                    null,
                    false,
                    t.message
                )
            }

        })
}