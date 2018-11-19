package com.example.onebyte.shopstore.Adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onebyte.shopstore.Models.PhotoSlide
import com.example.onebyte.shopstore.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_image_page.view.*

class ItemDetailSlider(private var mContext: Context, private val photoSlide: MutableList<PhotoSlide>?) : PagerAdapter() {
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0?.equals(p1)!!
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return photoSlide!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.single_image_page, container, false)
        Picasso.with(mContext)
                .load(photoSlide?.get(position)?.imageUrl)
                .into(view.imageView)
        container?.addView(view, 0)
        return view
    }

}