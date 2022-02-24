package com.vasilyevskii.currencytrackingtest.api

import com.vasilyevskii.currencytrackingtest.model.CurrencyModel
import kotlinx.coroutines.flow.StateFlow
import retrofit2.http.GET


interface ApiService {

    @GET("/latest")
    suspend fun getListLatestChangeRates(): StateFlow<List<CurrencyModel>>


}