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
            overridePendingTransition(0, 0)
        }, 2000)
    }

    private fun gotoWelcome() {
        Intent(this@SplashActivity, WelcomeActivity::class.java).apply {
            this.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            val optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@SplashActivity,
                     binding.layoutContent,
                    "logo")
            startActivity(this, optionsCompat.toBundle())
        }
    }

    override fun setUpObserver() {
    }

}