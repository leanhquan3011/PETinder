package com.leaquan.petinder.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.leaquan.petinder.R
import com.leaquan.petinder.util.Constant.Companion.DEFAULT_ANIMATION

inline fun <reified T : FragmentActivity> T?.pushFragment
(
    fragment : Fragment,
    container : Int = R.id.container
)
{
    this?.supportFragmentManager
        ?.beginTransaction()
        ?.setCustomAnimations(R.anim.sliding_in, DEFAULT_ANIMATION, R.anim.sliding_out, DEFAULT_ANIMATION)
        ?.addToBackStack(T::class.java.simpleName)
        ?.replace(container, fragment)
        ?.commit()
}

//todo research this
fun AppCompatActivity.onFragmentBackPressed(){
    if (supportFragmentManager.backStackEntryCount > 1)
        supportFragmentManager.popBackStack()
    else
        this.finish()
}
