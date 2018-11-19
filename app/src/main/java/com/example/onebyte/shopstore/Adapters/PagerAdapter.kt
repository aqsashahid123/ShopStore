package com.example.onebyte.shopstore.Adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.onebyte.shopstore.Views.Fragments.CartFragment
import com.example.onebyte.shopstore.Views.Fragments.HomeFragment
import com.example.onebyte.shopstore.Views.Fragments.SavedItemsFragment

public open class PagerAdapter(fm: FragmentManager, private val context: Context) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment.newInstance()
            1 -> return SavedItemsFragment.newInstance()
            2 -> return CartFragment.newInstance()
        }
        return return HomeFragment.newInstance()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return null

    }

}