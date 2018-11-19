package com.example.onebyte.shopstore.Views.Fragments

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.onebyte.shopstore.Adapters.CartAdapter
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.Views.Activities.DashboardActivity
import com.example.onebyte.shopstore.databinding.FragmentCartBinding
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(), View.OnClickListener {
    lateinit var  binding : FragmentCartBinding
    override fun onClick(p0: View?) {
        if (p0 === btnCheckout) {
            val intent = Intent(context, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    var dataList: ArrayList<HomeModel> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false)
        var model: HomeModel = HomeModel("Test Data0", "Discount : 10 %", "1000", "After discount 900")
        var model1: HomeModel = HomeModel("Test Data1", "Discount : 10 %", "1000", "After discount 900")
        var model2: HomeModel = HomeModel("Test Data2", "Discount : 10 %", "1000", "After discount 900")
        var model3: HomeModel = HomeModel("Test Data3", "Discount : 10 %", "1000", "After discount 900")
        var model4: HomeModel = HomeModel("Test Data4", "Discount : 10 %", "1000", "After discount 900")
        var model5: HomeModel = HomeModel("Test Data5", "Discount : 10 %", "1000", "After discount 900")
        var model6: HomeModel = HomeModel("Test Data6", "Discount : 10 %", "1000", "After discount 900")
        var model7: HomeModel = HomeModel("Test Data7", "Discount : 10 %", "1000", "After discount 900")
        dataList.add(model)
        dataList.add(model1)
        dataList.add(model2)
        dataList.add(model3)
        dataList.add(model4)
        dataList.add(model5)
        dataList.add(model6)
        dataList.add(model7)
        val activity = activity
        binding.rvCartItems.layoutManager= LinearLayoutManager(activity)
        binding.rvCartItems.adapter = CartAdapter(dataList)
        binding.btnCheckout.setOnClickListener(this)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                CartFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
