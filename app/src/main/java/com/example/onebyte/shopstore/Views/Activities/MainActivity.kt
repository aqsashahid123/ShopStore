package com.example.onebyte.shopstore.Views.Activities

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.onebyte.shopstore.databinding.ActivityMainBinding
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.ViewModels.TransactionViewModel


class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
         binding.vm = ViewModelProviders.of(this).get(TransactionViewModel::class.java)

    }
}
