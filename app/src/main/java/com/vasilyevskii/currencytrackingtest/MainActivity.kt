package com.vasilyevskii.currencytrackingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vasilyevskii.currencytrackingtest.adabter.CurrencyAdapter
import com.vasilyevskii.currencytrackingtest.databinding.ActivityMainBinding
import com.vasilyevskii.currencytrackingtest.viewmodel.CurrencyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val recyclerviewAdapter = CurrencyAdapter()

    private val viewModel: CurrencyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recycleView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerviewAdapter
        lifecycle.coroutineScope.launch {
            viewModel.getListLatestChangeRates().collect {
                recyclerviewAdapter.submitList(it)
            }
        }
    }
}