package com.leaquan.petinder.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import com.google.android.material.tabs.TabLayoutMediator
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.base.adapter.BasePagerAdapter
import com.leaquan.petinder.databinding.ActivityWelcomeBinding
import com.leaquan.petinder.ui.check_in.CheckInActivity
import com.leaquan.petinder.ui.welcome.fragments.Item1
import com.leaquan.petinder.ui.welcome.fragments.Item2
import com.leaquan.petinder.ui.welcome.fragments.Item3
import com.leaquan.petinder.util.Constant.Companion.ACTION
import com.leaquan.petinder.util.Constant.Companion.END_PREVIEW
import com.leaquan.petinder.util.Constant.Companion.IN_PREVIEW
import com.leaquan.petinder.util.Constant.Companion.LONG_ANIMATION
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.view_pager.currentItemWithAnimate


class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_welcome

    override fun setUp() {
        //status bar primary color
        statusBarColor()
        setUpAnimSharedElement()
        setUpViewPager()
        setUpAnimViewPager()
        setUpAnimButton()
        setUpActionButton()
    }

    private fun setUpActionButton() {
        with(binding) {
            btnAction.onClick {
                when(pagerContent.currentItem) {

                    IN_PREVIEW -> {
                        pagerContent.currentItemWithAnimate(
                            item = 1,
                            duration = LONG_ANIMATION
                        )
                    }
                    END_PREVIEW -> {
                        pagerContent.currentItemWithAnimate(
                            item = 2,
                            duration = LONG_ANIMATION
                        )
                        btnAction.text = PETinderApplication.getString(R.string.lets_do_it)
                    }
                    
                    ACTION -> { gotoLogin() }
                }
            }
        }
    }

    private fun gotoLogin() {
        Intent(this@WelcomeActivity, CheckInActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    override fun setUpObserver() {

    }

    private fun setUpAnimSharedElement() {
        window.sharedElementEnterTransition.duration = LONG_ANIMATION
        window.sharedElementReturnTransition.apply {
            this.duration = LONG_ANIMATION
            this.interpolator = DecelerateInterpolator()
        }
    }

    private fun setUpAnimViewPager() {
        AnimationUtils.loadAnimation(this@WelcomeActivity, R.anim.sliding_in_left_long).also {
            binding.pagerContent.animation = it
            binding.tabIndicator.animation = it
        }
    }

    private fun setUpAnimButton() {
        AnimationUtils.loadAnimation(this@WelcomeActivity, R.anim.fade_in).also {
            binding.btnAction.animation = it
        }
    }

    private fun setUpViewPager() {
        binding.pagerContent.apply {
            adapter = BasePagerAdapter(
                this@WelcomeActivity,
                listOf(
                    Item1(),
                    Item2(),
                    Item3()
                )
            )
            isUserInputEnabled = false
            TabLayoutMediator(binding.tabIndicator, this) {
                tab, _ ->
                tab.view.isEnabled = false
            }.attach()

        }
    }
}


