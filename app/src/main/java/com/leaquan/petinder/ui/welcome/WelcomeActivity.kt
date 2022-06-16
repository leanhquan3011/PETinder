package com.leaquan.petinder.ui.welcome

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityWelcomeBinding

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {

    private lateinit var fadeAnim : Animation
    private lateinit var enterAnim : Animation

    override fun inflateLayout(): Int = R.layout.activity_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        hideSystemUI()
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0) //no enter animation
        window.sharedElementEnterTransition.duration = 800 //set shared element animation
        window.sharedElementReturnTransition.duration.let { 800 }.also { DecelerateInterpolator() }



//        enterAnim = AnimationUtils.loadAnimation(
//            this@WelcomeActivity,
//            R.anim.anim_transit
//        ) //init animation
//
//        binding.layoutHeader.startAnimation(enterAnim) //linear start animation move
    }

    override fun setUp() {

    }

    override fun setUpObserver() {

    }
}