package com.example.onebyte.shopstore.ViewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.Repositories.HomeRepository

class HomeViewModel : ViewModel() {

    private var homeListObservable: LiveData<List<HomeModel>>? = null

    fun getHomeData(context: Context?){
        homeListObservable = HomeRepository.getInstance()?.recieveData(context)
    }

    fun getHomeListObservable(): LiveData<List<HomeModel>>? {
        return homeListObservable
    }
}