package com.leaquan.petinder.ui.login

import android.os.Bundle
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityLoginBinding
import com.leaquan.petinder.ui.login.login.LoginFragment
import com.leaquan.petinder.util.pushFragment

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        setDefaultStatusBarColor()
        super.onCreate(savedInstanceState)

        pushFragment(
            LoginFragment()
        )
    }

    override fun setUp() {

    }

    override fun setUpObserver() {
    }
}