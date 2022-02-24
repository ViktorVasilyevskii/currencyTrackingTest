package com.vasilyevskii.currencytrackingtest.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vasilyevskii.currencytrackingtest.databinding.ItemCurrencyBinding
import com.vasilyevskii.currencytrackingtest.model.CurrencyModel

class CurrencyAdapter(
): ListAdapter<CurrencyModel, CurrencyAdapter.CurrencyViewHolder>(DiffCallback) {

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<CurrencyModel>(){


            override fun areItemsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(
                oldItem: CurrencyModel,
                newItem: CurrencyModel
            ): Boolean {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(
            ItemCurrencyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CurrencyViewHolder(
        private var binding: ItemCurrencyBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(сurrencyModel: CurrencyModel){
            binding.nameCurrency.text = сurrencyModel.nameCurrency
            binding.nameCurrency.text = сurrencyModel.valueCurrency
        }
    }


}