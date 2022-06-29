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
import com.google.android.material.snackbar.Snackbar
import com.leaquan.petinder.R
import com.leaquan.petinder.base.view.BaseView
import com.leaquan.petinder.ui.custom_view.ToastPET
import com.leaquan.petinder.util.Constant
import com.leaquan.petinder.util.type.Toast.Type
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import android.view.WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN as FLAG_FORCE_NOT_FULLSCREEN
import com.leaquan.petinder.util.type.Toast.Duration.SHORT
import com.leaquan.petinder.util.type.Toast.Duration.LONG

abstract class BaseActivity <DB : ViewDataBinding> : AppCompatActivity(), BaseView, KodeinAware {

    open lateinit var binding: DB

    override val kodein by  kodein()

    override fun provideRootView(): View? = binding.root

    override fun provideContext(): Context? = this

    @ColorInt
    open val customStatusBarColor: Int = Color.WHITE

    @LayoutRes
    abstract fun inflateLayout(): Int

    @AnimRes
    open val animationEnter : Int = Constant.DEFAULT_ANIMATION

    @AnimRes
    open val animationLeave : Int = Constant.DEFAULT_ANIMATION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, inflateLayout())
        overridePendingTransition(animationEnter, animationLeave)
        setUp()
        setUpObserver()
    }

    fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun showShortToast(message: String, type: Type) {
        ToastPET(this).makeText(
            this,
            message,
            type of SHORT
        )?.show()
    }

    fun showLongToast(message: String, type: Type) {
        ToastPET(this).makeText(
            this,
            message,
            type of LONG
        )?.show()
    }

    //status bar -> white
    open fun enableLightStatusBar(){
        val window = window
        val decorView: View = window.decorView
        WindowInsetsControllerCompat(window, decorView).also { wic ->
            wic.isAppearanceLightStatusBars = true // true or false as desired.
        }
        window.statusBarColor = customStatusBarColor
    }

    //custom status bar -> primary color
    open fun setDefaultStatusBarColor(){
        window.also {
            it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            it.statusBarColor = getColor(R.color.colorPrimaryDark)
        }
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
