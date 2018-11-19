package com.example.onebyte.shopstore.Views.Fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Adapters.SavedItemsAdapter
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.R


class SavedItemsFragment : Fragment() {
    var dataList: ArrayList<HomeModel> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view :View = inflater.inflate(R.layout.fragment_saved_items, container, false)

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
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvSavedItems) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = SavedItemsAdapter(dataList)


        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                SavedItemsFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
