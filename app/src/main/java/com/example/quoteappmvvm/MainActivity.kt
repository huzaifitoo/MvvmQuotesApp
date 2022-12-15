package com.example.quoteappmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.quoteappmvvm.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mQuotesLearningViewModel: QuotesLearningViewModel
    private var mQuotes: List<QuotesLearningResponseModelItem?> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuotesLearningViewModel = ViewModelProvider(this).get(QuotesLearningViewModel::class.java)
        mQuotesLearningViewModel.getQuotes()

        mQuotesLearningViewModel.getQuotesLearningLiveData().observe(this) {
            if (!it.success) return@observe
            if (it.data == null) return@observe
            mQuotes = it.data
            Log.d("DATA", it.data.toString())
        }
        binding.srlQuotes.setOnRefreshListener {
            if (mQuotes.isNotEmpty()) {
                binding.idQuote.text = mQuotes[Random.nextInt(0, mQuotes.size - 1)]?.text.toString()
            }
            binding.srlQuotes.isRefreshing = false
        }
    }
}