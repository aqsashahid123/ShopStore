package com.example.onebyte.shopstore.Views.Activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.onebyte.shopstore.Adapters.ItemDetailSlider
import com.example.onebyte.shopstore.BR
import com.example.onebyte.shopstore.Models.HomeModel
import com.example.onebyte.shopstore.Models.PhotoSlide
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.databinding.ActivityItemDetailBinding
import kotlinx.android.synthetic.main.activity_item_detail.*
import java.util.*

class ItemDetail : AppCompatActivity(), View.OnClickListener {

    private var listUrl: MutableList<PhotoSlide>? = null
    private var swipeTimer = Timer()
    private var isTimerRunning = true
    private var nextPage = 0

    lateinit var binding: ActivityItemDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
        var homeModel: HomeModel = HomeModel("Test Data", "20%", "800", "Some fancy Description")
        binding.layoutPrice?.homeModelPrice = homeModel
        binding.layoutDescription?.descriptionData = homeModel
        binding.setVariable(BR.homeModel, homeModel)

        binding.btnBuyNow.setOnClickListener(this)
        listUrl = mutableListOf()

        loadData()
    }

    override fun onResume() {
        super.onResume()
        if (!isTimerRunning)
            setUpAutoSlider()
    }

    override fun onStop() {
        super.onStop()
        swipeTimer.cancel()
        isTimerRunning = false
    }

    private fun setUpAutoSlider() {
        val handler = Handler()
        val update = Runnable {
            nextPage = viewPager.currentItem + 1
            Log.d("CurP->", nextPage.toString())
            if (nextPage == listUrl?.size) {
                nextPage = 0
            }
            viewPager.setCurrentItem(nextPage, true)
        }
        swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 3000, 3000)
    }

    fun loadData() {
        listUrl?.add(PhotoSlide("https://i.pinimg.com/originals/5c/74/75/5c7475506de1851c08f5e0eeb20c77db.png", "1000", "loc", "bio"))
        listUrl?.add(PhotoSlide("https://i.pinimg.com/originals/ae/f9/e7/aef9e76d6e16f212d731fe8e0c1fcf5c.jpg", "1000", "loc", "bio"))
        listUrl?.add(PhotoSlide("https://i.pinimg.com/originals/5c/74/75/5c7475506de1851c08f5e0eeb20c77db.png", "1000", "loc", "bio"))
        listUrl?.add(PhotoSlide("https://i.pinimg.com/originals/ae/f9/e7/aef9e76d6e16f212d731fe8e0c1fcf5c.jpg", "1000", "loc", "bio"))
        val imageAdapter = ItemDetailSlider(this, listUrl)
        viewPager.adapter = imageAdapter
        tabLayout.setupWithViewPager(viewPager)
        setUpAutoSlider()
    }

    override fun onClick(p0: View?) {
        if (p0 === btnBuyNow) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("fragNum", "1")
            startActivity(intent)
        }
    }

}
