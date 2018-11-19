package com.example.onebyte.shopstore.Views.Activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.example.onebyte.shopstore.Adapters.PagerAdapter
import com.example.onebyte.shopstore.R
import com.example.onebyte.shopstore.databinding.ActivityDashboardBinding
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    private var mSectionsPagerAdapter: PagerAdapter? = null
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        mSectionsPagerAdapter = PagerAdapter(supportFragmentManager, this)

        binding.container.adapter = mSectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.container)
        setTabs()
        setCurrentTab()
    }

    fun setTabs() {
        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(0)!!.text = "Home"
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_like)
        binding.tabs.getTabAt(1)!!.text = "Saved"
        binding.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_shopping_cart)
        binding.tabs.getTabAt(2)!!.text = "Cart"
    }

    fun setCurrentTab() {
        if (intent.extras["fragNum"] == "1") {
            binding.tabs.getTabAt(2)?.select()
        }
    }
}
