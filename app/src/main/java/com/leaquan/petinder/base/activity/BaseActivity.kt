package com.leaquan.petinder.base.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.AnimRes
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.leaquan.petinder.R
import com.leaquan.petinder.base.view.BaseView

abstract class BaseActivity <DB : ViewDataBinding> : AppCompatActivity(), BaseView {

    open lateinit var binding: DB

    override fun provideRootView(): View? = binding.root

    override fun provideContext(): Context? = this

    @ColorInt
    open val customStatusBarColor: Int = Color.WHITE

    @LayoutRes
    abstract fun inflateLayout(): Int

    @AnimRes
    open val animationEnter : Int = R.anim.anim_blank

    @AnimRes
    open val animationLeave : Int = R.anim.anim_blank

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, inflateLayout())
        overridePendingTransition(animationEnter, animationLeave)
        setUp()
        setUpObserver()
    }

    open fun enableLightStatusBar(){
        val window = window
        val decorView: View = window.decorView
        WindowInsetsControllerCompat(window, decorView).also { wic ->
            wic.isAppearanceLightStatusBars = true // true or false as desired.
        }
        window.statusBarColor = customStatusBarColor
    }

    open fun hideSystemUI(){
        //no title
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // no action bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
