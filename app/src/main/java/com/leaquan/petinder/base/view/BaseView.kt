package com.leaquan.petinder.base.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.leaquan.petinder.ui.view.ToastPET
import com.leaquan.petinder.util.type.Toast

interface BaseView {

    fun provideRootView(): View?

    fun provideContext(): Context?

    fun setUp()

    fun setUpObserver()


    fun hideKeyboard() {
        provideRootView()?.let {
            val inputMethodManager = provideContext()?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun showKeyBoard() {
        val imm = provideContext()?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }
}