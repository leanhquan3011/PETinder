package com.leaquan.petinder.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityHomeBinding
import com.leaquan.petinder.util.extension.onClick

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private lateinit var auth : FirebaseAuth

    override fun inflateLayout(): Int = R.layout.activity_home

    override fun setUp() {
        enableLightStatusBar()
        auth = FirebaseAuth.getInstance()

        binding.btn.onClick {
            auth.signOut()
        }
    }
    override fun setUpObserver() {

    }
}