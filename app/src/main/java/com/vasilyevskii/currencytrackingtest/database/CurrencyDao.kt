package com.vasilyevskii.currencytrackingtest.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface CurrencyDao {

    @Query("SELECT * FROM CurrencyData")
    fun getAll() : Flow<List<CurrencyData>>

    @Query("SELECT * FROM CurrencyData WHERE favorite = :favorite")
    fun getFavorite(favorite: Boolean): Flow<List<CurrencyData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currencyData: CurrencyData)

    @Delete
    fun delete(currencyData: CurrencyData)

}