package com.example.onebyte.shopstore.ViewModels

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.onebyte.shopstore.Views.Activities.LoginActivity
import com.example.onebyte.shopstore.Views.Activities.RegisterActivity

class TransactionViewModel() :  ViewModel() {

    fun onButtonClick(context: Context) {
        Log.e("================>","Pressed")
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
    }
    fun goToRegister(context: Context) {
        Log.e("================>","Pressed")
        val intent = Intent(context, RegisterActivity::class.java)
        context.startActivity(intent)
    }
}