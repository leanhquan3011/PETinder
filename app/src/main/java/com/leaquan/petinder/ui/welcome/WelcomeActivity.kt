package com.leaquan.petinder.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import com.google.android.material.tabs.TabLayoutMediator
import com.leaquan.petinder.App
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.base.adapter.BasePagerAdapter
import com.leaquan.petinder.databinding.ActivityWelcomeBinding
import com.leaquan.petinder.ui.login.LoginActivity
import com.leaquan.petinder.ui.welcome.fragments.Item1
import com.leaquan.petinder.ui.welcome.fragments.Item2
import com.leaquan.petinder.ui.welcome.fragments.Item3
import com.leaquan.petinder.util.extension.onClick
import com.leaquan.petinder.util.type.AnimationDuration
import com.leaquan.petinder.util.type.StateViewPager
import com.leaquan.petinder.util.view_pager.setCurrentItem


class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        hideSystemUI()
        super.onCreate(savedInstanceState)
    }

    override fun setUp() {
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

                    StateViewPager.IN_PREVIEW.value -> {
                        pagerContent.setCurrentItem(
                            item = 1,
                            duration = AnimationDuration.LONG.value
                        )
                    }
                    StateViewPager.END_PREVIEW.value -> {
                        pagerContent.setCurrentItem(
                            item = 2,
                            duration = AnimationDuration.LONG.value
                        )
                        btnAction.text = App.getString(R.string.lets_do_it)
                    }
                    
                    StateViewPager.ACTION.value -> { gotoLogin() }
                }
            }
        }
    }

    private fun gotoLogin() {
        Intent(this@WelcomeActivity, LoginActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    override fun setUpObserver() {

    }

    private fun setUpAnimSharedElement() {
        window.sharedElementEnterTransition.duration = AnimationDuration.LONG.value
        window.sharedElementReturnTransition.apply {
            this.duration = AnimationDuration.LONG.value
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

            TabLayoutMediator(binding.tabIndicator, this) {
                tab, _ ->
                tab.view.isEnabled = false
            }.attach()

            beginFakeDrag()
        }
    }
}


