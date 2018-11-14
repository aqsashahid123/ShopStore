package com.example.onebyte.shopstore.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Models.HomeModel
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.databinding.RvCellBinding


class HomeAdapter(var list: List<HomeModel>) : RecyclerView.Adapter<HomeAdapter.Holder>() {
    lateinit var layoutInflater: LayoutInflater
    lateinit var binding: RvCellBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        binding = DataBindingUtil
                .inflate<RvCellBinding>(LayoutInflater.from(parent.context), R.layout.rv_cell,
                        parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    class Holder(val binding: RvCellBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeModel){
            with(binding){
                tvDatum.text = item.dataum
                tvDiscount.text =item.discount
                tvName.text = item.name
                tvPrice.text = item.price
            }
        }
    }
}