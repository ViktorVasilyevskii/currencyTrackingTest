package com.vasilyevskii.currencytrackingtest.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull @ColumnInfo(name = "name_currency") val nameCurrency: String,
    @NonNull @ColumnInfo(name = "value_currency") val valueCurrency: String,
    @NonNull @ColumnInfo(name = "favorite") val favorite: Boolean
)