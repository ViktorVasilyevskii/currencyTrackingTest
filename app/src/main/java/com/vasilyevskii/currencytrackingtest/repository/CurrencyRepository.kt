package com.vasilyevskii.currencytrackingtest.repository

import com.vasilyevskii.currencytrackingtest.api.ApiService
import com.vasilyevskii.currencytrackingtest.database.CurrencyDao
import com.vasilyevskii.currencytrackingtest.database.CurrencyData
import com.vasilyevskii.currencytrackingtest.model.CurrencyModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CurrencyRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val currencyDao: CurrencyDao
    ){
    suspend fun getListLatestChangeRates(): StateFlow<List<CurrencyModel>> = apiService.getListLatestChangeRates()

    fun fullCurrency(): Flow<List<CurrencyData>> = currencyDao.getAll()
    fun favoriteCurrency(favorite: Boolean): Flow<List<CurrencyData>> = currencyDao.getFavorite(favorite)
}