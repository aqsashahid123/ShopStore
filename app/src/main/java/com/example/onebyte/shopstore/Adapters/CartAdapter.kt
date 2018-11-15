package com.example.onebyte.shopstore.Adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.databinding.CellCartBinding
import com.example.onebyte.shopstore.databinding.RvSavedItemsBinding

class CartAdapter(var list: List<HomeModel>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    lateinit var binding: CellCartBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil
                .inflate<CellCartBinding>(LayoutInflater.from(parent.context), R.layout.cell_cart,
                        parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class ViewHolder(val binding: CellCartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeModel) {
            with(binding) {
                tvDealName.text = item.name
                tvDealDescription.text = item.dataum
                tvDealPrice.text = item.price
            }
        }
    }
}