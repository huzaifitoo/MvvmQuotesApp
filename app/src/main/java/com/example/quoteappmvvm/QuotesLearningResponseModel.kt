package com.example.quoteappmvvm

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuotesLearningResponseModel(

	@field:SerializedName("QuotesLearningResponseModel")
	val quotesLearningResponseModel: List<QuotesLearningResponseModelItem?>? = null
) : Parcelable

@Parcelize
data class QuotesLearningResponseModelItem(

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("text")
	val text: String? = null
) : Parcelable
