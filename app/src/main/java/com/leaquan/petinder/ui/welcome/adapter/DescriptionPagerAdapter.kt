package com.leaquan.petinder.ui.welcome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.leaquan.petinder.databinding.ItemDescriptionBinding

class DescriptionPagerAdapter(
    private var desc : ArrayList<WelcomeDesc>,
) : PagerAdapter() {

    override fun getCount(): Int = desc.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemDescriptionBinding.inflate(LayoutInflater.from(container.context), container, false)
        binding.description = desc[position]
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun submitList(welcomes: ArrayList<WelcomeDesc>) {
        this.desc = welcomes
        notifyDataSetChanged()
    }

    fun refresh() {
        this.desc = arrayListOf()
    }

}