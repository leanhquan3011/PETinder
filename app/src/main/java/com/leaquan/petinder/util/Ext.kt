package com.leaquan.petinder.util.extension

import android.util.Log

//TODO: Make this clear
fun WTF(msg: String?, tag: String = "WTF"): Int{
    return Log.e(tag, "$msg")
}