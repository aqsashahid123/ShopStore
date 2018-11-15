package com.example.onebyte.shopstore.ViewModels

import android.arch.lifecycle.AndroidViewModel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Observable
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View
import com.example.onebyte.shopstore.LoginActivity
import com.example.onebyte.shopstore.RegisterActivity
import java.util.*

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