package com.leaquan.petinder.ui.check_in

import android.os.Bundle
import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityCheckinBinding
import com.leaquan.petinder.ui.check_in.login.LoginFragment
import com.leaquan.petinder.util.pushFragment

class CheckInActivity : BaseActivity<ActivityCheckinBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_checkin

    override fun setUp() {
        pushFragment(
            LoginFragment.instance(
                this.packageName.toString()
            )
        )
        setDefaultStatusBarColor()
    }

    override fun setUpObserver() = Unit
}