package com.leaquan.petinder.base.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.leaquan.petinder.base.view.BaseView

abstract class BaseActivity <DB : ViewDataBinding> : AppCompatActivity(), BaseView {

    open lateinit var binding: DB

    override fun provideRootView(): View? = binding.root

    override fun provideContext(): Context? = this

    @ColorInt
    open val customStatusBarColor: Int = Color.WHITE

    @LayoutRes
    abstract fun inflateLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, inflateLayout())
        hideSystemUI()
        setStatusBarColor()
        setUp()
        setUpObserver()
    }

    private fun setStatusBarColor() {
        val window = window
        val decorView: View = window.decorView
        WindowInsetsControllerCompat(window, decorView).also { wic ->
            wic.isAppearanceLightStatusBars = true // true or false as desired.
        }
        window.statusBarColor = customStatusBarColor

    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }
}