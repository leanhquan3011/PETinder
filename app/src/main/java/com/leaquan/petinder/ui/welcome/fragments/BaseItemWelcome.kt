package com.leaquan.petinder.ui.welcome.fragments

import androidx.annotation.DrawableRes
import com.leaquan.petinder.R
import com.leaquan.petinder.base.fragment.BaseFragment
import com.leaquan.petinder.databinding.ItemWelcomeBinding

abstract class BaseItemWelcome : BaseFragment<ItemWelcomeBinding>() {

    override fun inflateLayout(): Int = R.layout.item_welcome

    abstract fun inflateTitle() : String

    abstract fun inflateDescription() : String

    @DrawableRes
    abstract fun inflateSrcImg() : Int

    override fun setUp() {
        binding.tvTitle.text = inflateTitle()
        binding.tvDescription.text = inflateDescription()
        binding.ivContent.setImageResource(inflateSrcImg())
    }

    override fun setUpObserver() = Unit
}