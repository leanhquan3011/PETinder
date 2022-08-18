package com.leaquan.petinder.ui.check_in.country_dialog

import androidx.databinding.BindingAdapter
import com.leaquan.petinder.ui.view.TextViewPET

@BindingAdapter("showCountryCode")
fun showCountryCode(textView : TextViewPET, content : String?) {
    textView.text = content?.let {
        "+$it"
    } ?:"+84"
}