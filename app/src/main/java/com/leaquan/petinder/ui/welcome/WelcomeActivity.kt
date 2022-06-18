package com.leaquan.petinder.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import com.leaquan.petinder.App
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityWelcomeBinding
import com.leaquan.petinder.ui.login.LoginActivity
import com.leaquan.petinder.ui.welcome.adapter.DescriptionPagerAdapter
import com.leaquan.petinder.ui.welcome.adapter.WelcomeDesc
import com.leaquan.petinder.util.extension.onClick

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    private lateinit var pagerAdapter: DescriptionPagerAdapter
    private lateinit var desc : ArrayList<WelcomeDesc>

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
        mocksData()
        TODO("Fixed Scroll ViewPager")
    }

    private fun setUpActionButton() {
        with(binding) {
            btnAction.onClick {
                when(pagerContent.currentItem) {
                    0 -> {//IN_PREVIEW
                        pagerContent.currentItem = 1
                    }
                    1 -> {//END_PREVIEW
                        pagerContent.currentItem = 2
                        btnAction.text = App.getString(R.string.lets_do_it)
                    }
                    2 -> {//ACTION
                        gotoLogin()
                    }
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
        window.sharedElementEnterTransition.duration = 600
        window.sharedElementReturnTransition.apply {
            this.duration = 600
            this.interpolator = DecelerateInterpolator()
        }
    }

    private fun setUpAnimViewPager() {
        AnimationUtils.loadAnimation(this@WelcomeActivity, R.anim.anim_enter_pager).also {
            binding.pagerContent.animation = it
            binding.tabIndicator.animation = it
        }
    }

    private fun setUpAnimButton() {
        AnimationUtils.loadAnimation(this@WelcomeActivity, R.anim.anim_fade_in).also {
            binding.btnAction.animation = it
        }
    }

    private fun setUpViewPager() {
        pagerAdapter = DescriptionPagerAdapter(arrayListOf())
        desc = arrayListOf()
        binding.pagerContent.apply {
            currentItem = 0
            adapter = pagerAdapter
            beginFakeDrag()
        }.also {
            binding.tabIndicator.setupWithViewPager(it)
            binding.tabIndicator.isClickable = false
            binding.tabIndicator.isEnabled = false
        }
    }

    private fun mocksData() {
        desc.add (
            WelcomeDesc(
                R.drawable.img_welcom1,
                App.getString(R.string.description_title1),
                App.getString(R.string.description_content1)
            )
        )
        desc.add(
            WelcomeDesc(
                R.drawable.img_welcom2,
                App.getString(R.string.description_title2),
                App.getString(R.string.description_content2)
            )
        )
        desc.add(
            WelcomeDesc(
                R.drawable.img_welcom3,
                App.getString(R.string.description_title3),
                App.getString(R.string.description_content3)
            )
        )
        pagerAdapter.submitList(desc)
    }
}