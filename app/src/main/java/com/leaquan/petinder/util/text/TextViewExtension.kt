package com.leaquan.petinder.util.text

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import com.leaquan.petinder.ui.custom_view.TextViewPET

fun TextViewPET.gradientText() {
    val paint = this.paint
    val width = paint.measureText(this.text.toString())
    val textShader: Shader = LinearGradient(0f, 0f, width, this.textSize, intArrayOf(
        Color.parseColor("#EF80A6"),
        Color.parseColor("#FF846F")
    ), null, Shader.TileMode.CLAMP)

    this.paint.shader = textShader
}


