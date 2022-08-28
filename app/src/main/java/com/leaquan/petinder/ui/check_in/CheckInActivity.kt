package com.leaquan.petinder.ui.check_in

import com.leaquan.petinder.R
import com.leaquan.petinder.base.activity.BaseActivity
import com.leaquan.petinder.databinding.ActivityCheckinBinding
import com.leaquan.petinder.ui.check_in.login.LoginFragment
import com.leaquan.petinder.util.onFragmentBackPressed
import com.leaquan.petinder.util.pushFragment
import com.leaquan.petinder.util.type.Toast

class CheckInActivity : BaseActivity<ActivityCheckinBinding>() {

    override fun inflateLayout(): Int = R.layout.activity_checkin

    override fun setUp() {
        //status bar primary color
        statusBarColor()

        pushFragment(
            LoginFragment.instance(
                this.packageName.toString()
            )
        )

        with(binding) {
            root.getTransition(R.id.motion_transit).isEnabled = false
        }
    }

    override fun setUpObserver() = Unit

    override fun onBackPressed() {
        onFragmentBackPressed()
    }
}