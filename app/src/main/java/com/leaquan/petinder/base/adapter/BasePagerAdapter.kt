package com.leaquan.petinder.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class BasePagerAdapter(AF : FragmentActivity,val LSF : List<Fragment>) : FragmentStateAdapter(AF) {

    override fun getItemCount(): Int = LSF.size

    override fun createFragment(position: Int): Fragment = LSF[position]
}