package com.example.onebyte.shopstore.Adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.onebyte.shopstore.CartFragment
import com.example.onebyte.shopstore.HomeFragment
import com.example.onebyte.shopstore.SavedItemsFragment

public class PagerAdapter (fm: FragmentManager, private val context: Context) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment.newInstance()
            1 -> return SavedItemsFragment.newInstance()
            2 -> return CartFragment.newInstance()
//            3 -> return HomeFragment.newInstance()
//            4 -> return HomeFragment.newInstance()
        }
        return return HomeFragment.newInstance()
    }

    override fun getCount(): Int {
        // Show 5 total pages.
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // return null to show no title.
        return null

    }

}