package com.leaquan.petinder.util.text

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.leaquan.petinder.PETinderApplication
import com.leaquan.petinder.R
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


fun TextView.setLoginText(clicks : ClickableSpan?){
    val link = PETinderApplication.getString(R.string.login)
    val textMess: String = PETinderApplication.getString(R.string.have_account_login)
    val spannableStringBuilder = SpannableStringBuilder(textMess)
    val startPrivacyIndex = textMess.indexOf(link)

    if (startPrivacyIndex != -1) {
        val endIndex = startPrivacyIndex + link.length
        spannableStringBuilder.setSpan(
            clicks,
            startPrivacyIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    this.text = spannableStringBuilder
    this.movementMethod = LinkMovementMethod.getInstance()
    this.setLinkTextColor(
        ContextCompat.getColor(
            PETinderApplication.getInstance().applicationContext,
            R.color.colorAccent
        )
    )
}
