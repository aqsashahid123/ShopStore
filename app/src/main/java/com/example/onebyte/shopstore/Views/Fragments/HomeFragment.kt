package com.example.onebyte.shopstore.Views.Fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Adapters.HomeAdapter
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.ViewModels.HomeViewModel
import com.example.onebyte.shopstore.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val activity = activity
        binding.rvHomeItems.layoutManager = GridLayoutManager(activity, 2)
        setData()
        return binding.root

    }

    private fun setData() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java!!)
        viewModel.getHomeData(context)
        observeViewModel(viewModel, -1, null)
    }


    private fun observeViewModel(viewModel: HomeViewModel, itemPosition: Int, home: HomeModel?) {
        viewModel.getHomeListObservable()?.observe(this, Observer<List<HomeModel>> { homeModels ->
            binding.rvHomeItems.adapter = HomeAdapter(
                    homeModels,
                    context
            )

        })
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
