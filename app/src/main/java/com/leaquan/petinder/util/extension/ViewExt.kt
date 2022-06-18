package com.leaquan.petinder.util.extension

import android.view.View

//TODO(make this function clear)
inline fun <reified T: View>T.onClick(crossinline onClick: (view: T) -> Unit){
    setOnClickListener {
        onClick.invoke(it as T)
    }
}