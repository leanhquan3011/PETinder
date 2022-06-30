package com.leaquan.petinder.util.extension

import android.util.Log
import android.view.View

fun WTF(msg: String?, tag: String = "WTF"): Int{
    return Log.e(tag, "$msg")
}

//TODO make this clear
inline fun <reified T: View> T.onClick(crossinline onClick: (view: T) -> Unit){
    setOnClickListener {
        onClick.invoke(it as T)
    }
}