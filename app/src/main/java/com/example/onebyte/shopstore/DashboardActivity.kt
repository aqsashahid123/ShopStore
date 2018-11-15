package com.example.onebyte.shopstore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.example.onebyte.shopstore.Adapters.PagerAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    private var mSectionsPagerAdapter: PagerAdapter? = null
    private var mViewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mSectionsPagerAdapter = PagerAdapter(supportFragmentManager, this)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<ViewPager?>(R.id.container)
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabs = findViewById<View>(R.id.tabs) as TabLayout
        tabs.setupWithViewPager(mViewPager)
        setTabs()
    }

    fun setTabs() {
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        tabs.getTabAt(0)!!.text = "Home"
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_like)
        tabs.getTabAt(1)!!.text = "Saved"
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_shopping_cart)
        tabs.getTabAt(2)!!.text = "Cart"
    }
}
