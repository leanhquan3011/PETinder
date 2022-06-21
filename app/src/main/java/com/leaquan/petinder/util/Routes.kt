package com.leaquan.petinder.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.leaquan.petinder.R

inline fun <reified T : FragmentActivity> T?.pushFragment (fragment : Fragment, container : Int = R.id.container) {

    this?.supportFragmentManager
        ?.beginTransaction()
        ?.setCustomAnimations(R.anim.sliding_in, R.anim.sliding_out)
        ?.addToBackStack(T::class.java.simpleName)
        ?.replace(container, fragment)
        ?.commit()
}
