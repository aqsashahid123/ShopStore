package com.example.onebyte

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Adapters.HomeAdapter
import com.example.onebyte.shopstore.Models.HomeModel

import com.example.onebyte.shopstore.R


class HomeFragment : Fragment() {

    var dataList: ArrayList<HomeModel> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_home, container,
                false)
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
        dataList.add(model)
        dataList.add(model)
        val activity = activity
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvHomeItems) as RecyclerView
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = HomeAdapter(dataList)
        return view

    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
