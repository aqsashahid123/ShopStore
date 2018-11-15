package com.example.onebyte.shopstore

import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(), View.OnClickListener {
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
        val view: View = inflater.inflate(R.layout.fragment_cart, container, false)
        var model: HomeModel = HomeModel("Test Data", "Discount : 10 %", "1000", "After discount 900")
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        dataList.add(model)
        val activity = activity
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCartItems) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CartAdapter(dataList)
        var btnCheckout = view.findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener(this)

        return view
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
