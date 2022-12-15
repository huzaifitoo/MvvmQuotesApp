package com.example.quoteappmvvm
import androidx.lifecycle.MutableLiveData

class QuotesLearningRepository {

    private var mQuotesLearningNetworkDataSource: QuotesLearningNetworkDataSource =
        QuotesLearningNetworkDataSource()

    fun getQuotes(
        data: MutableLiveData<GenericResponse<List<QuotesLearningResponseModelItem?>?>>
    ) = mQuotesLearningNetworkDataSource.getQuotes(data)

}