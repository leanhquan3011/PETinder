package com.leaquan.petinder.util.view_extension

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.AppCompatImageView
import com.leaquan.petinder.R
import com.leaquan.petinder.ui.custom_view.EdittextPET

fun EdittextPET.transformation(imageView : AppCompatImageView) {
    val anim : Animation = AnimationUtils.loadAnimation(this.context, R.anim.rotate_fade)

    if (this.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
        imageView.setImageResource(R.drawable.ic_hide_password)
        imageView.animation = anim
        this.transformationMethod = HideReturnsTransformationMethod.getInstance()
    } else {
        imageView.setImageResource(R.drawable.ic_show_password)
        imageView.animation = anim
        this.transformationMethod = PasswordTransformationMethod.getInstance()
    }

}