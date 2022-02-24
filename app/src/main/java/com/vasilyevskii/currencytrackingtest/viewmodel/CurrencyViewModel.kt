package com.vasilyevskii.currencytrackingtest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vasilyevskii.currencytrackingtest.database.CurrencyDao
import com.vasilyevskii.currencytrackingtest.database.CurrencyData
import com.vasilyevskii.currencytrackingtest.model.CurrencyModel
import com.vasilyevskii.currencytrackingtest.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject
constructor(
    private val currencyRepository: CurrencyRepository
    ): ViewModel() {

        suspend fun getListLatestChangeRates() : StateFlow<List<CurrencyModel>> {
            return currencyRepository.getListLatestChangeRates()
        }

        fun getAllCurrency() : Flow<List<CurrencyData>> {
            return currencyRepository.fullCurrency()
        }


        fun getFavorite() : Flow<List<CurrencyData>> {
        return currencyRepository.favoriteCurrency(true)
        }

}

