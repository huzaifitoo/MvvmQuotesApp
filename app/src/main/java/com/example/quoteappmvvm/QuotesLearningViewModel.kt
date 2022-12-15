package com.example.quoteappmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuotesLearningViewModel : ViewModel() {

    private var mQuotesLearningRepository : QuotesLearningRepository = QuotesLearningRepository()
    private val mLearningQuotesLiveData : MutableLiveData<GenericResponse<List<QuotesLearningResponseModelItem?>?>> =
        MutableLiveData<GenericResponse<List<QuotesLearningResponseModelItem?>?>>()

    fun getQuotesLearningLiveData(): LiveData<GenericResponse<List<QuotesLearningResponseModelItem?>?>> {
        return mLearningQuotesLiveData
    }

    fun getQuotes(){
        mQuotesLearningRepository.getQuotes(mLearningQuotesLiveData)
    }
}