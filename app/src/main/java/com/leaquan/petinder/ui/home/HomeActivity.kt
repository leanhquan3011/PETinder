package com.leaquan.petinder.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_home

    override fun setUp() {
        enableLightStatusBar()
    }
    override fun setUpObserver() {

    }
}