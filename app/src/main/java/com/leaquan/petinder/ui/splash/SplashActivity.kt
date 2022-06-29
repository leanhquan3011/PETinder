package com.leaquan.petinder.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.app.ActivityOptionsCompat
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivitySplashBinding
import com.leaquan.petinder.ui.welcome.WelcomeActivity
import com.leaquan.petinder.util.Constant.Companion.SPLASH_TIMER


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        hideSystemUI()
        super.onCreate(savedInstanceState)
    }

    override fun setUp() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            gotoWelcome()
            finish()
        }, SPLASH_TIMER)
    }

    override fun setUpObserver() {}

    private fun gotoWelcome() {
        Intent(this@SplashActivity, WelcomeActivity::class.java).apply {
            val optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@SplashActivity,
                     binding.layoutContent,
                    "transitLogo")
            startActivity(this, optionsCompat.toBundle())
        }
    }

}