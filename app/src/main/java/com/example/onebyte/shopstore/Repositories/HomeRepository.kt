package com.example.onebyte.shopstore.Repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.onebyte.shopstore.Models.HomeModel

class HomeRepository {
    companion object {
         var homeRepository: HomeRepository? = null


        @Synchronized
        fun getInstance(): HomeRepository? {
            if (homeRepository == null) {
                homeRepository = HomeRepository()
            }
            return homeRepository
        }
    }

    fun recieveData(context: Context?): LiveData<List<HomeModel>> {
        val data = MutableLiveData<List<HomeModel>>()
        var dataList: ArrayList<HomeModel> = ArrayList()
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
        data.value = dataList

        return data

    }

}