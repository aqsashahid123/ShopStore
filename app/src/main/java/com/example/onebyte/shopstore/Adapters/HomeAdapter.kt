package com.example.onebyte.shopstore.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Models.HomeModel
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import com.example.onebyte.shopstore.BR
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.Views.Activities.ItemDetail
import com.example.onebyte.shopstore.Views.Activities.RegisterActivity
import com.example.onebyte.shopstore.databinding.RvCellBinding


class HomeAdapter(var list: List<HomeModel>?, val context: Context?) : RecyclerView.Adapter<HomeAdapter.Holder>() {
    lateinit var layoutInflater: LayoutInflater
    lateinit var binding: RvCellBinding
    //lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        binding = DataBindingUtil
                .inflate<RvCellBinding>(LayoutInflater.from(parent.context), R.layout.rv_cell,
                        parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.binding.setVariable(BR.homeItemsModel,list?.get(position))
        binding.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ItemDetail::class.java)
            context!!.startActivity(intent)
        })
    }

    fun setDataList(list: List<HomeModel>?) {
        this.list = list
        notifyItemInserted(0)

    }

    class Holder(val binding: RvCellBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    public interface Listeners {
        public fun onClickLikeButton()
    }
}