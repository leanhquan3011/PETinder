package com.leaquan.petinder.ui.custom_view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.leaquan.petinder.R
import com.leaquan.petinder.databinding.LayoutToastBinding
import com.leaquan.petinder.util.Toast.Companion.ERROR
import com.leaquan.petinder.util.Toast.Companion.SUCCESS
import com.leaquan.petinder.util.Toast.Companion.WARNING

open class ToastPET(context: Context?) : Toast(context) {

    lateinit var binding : LayoutToastBinding

    open fun makeText(
        context: Context?,
        message: String?,
        duration: Int,
        type: Int,
    ): Toast? {
        val toast = Toast(context)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_toast, null, false)
        binding.toastText.text = message ?: ""

        when (type) {
            SUCCESS -> {
                binding.toastIcon.setImageResource(R.drawable.ic_tick_green_white)
                binding.toastType.setBackgroundResource(R.drawable.toast_success_shape)
            }
            WARNING -> {
                binding.toastIcon.setImageResource(R.drawable.ic_warning_orange)
                binding.toastType.setBackgroundResource(R.drawable.toast_warning_shape)
            }
            ERROR -> {
                binding.toastIcon.setImageResource(R.drawable.ic_warning_transparent)
                binding.toastType.setBackgroundResource(R.drawable.toast_error_shape)
            }
        }

        toast.apply {
            view = binding.root
            setGravity(Gravity.TOP, 0, 150)
        }
        return toast
    }
}