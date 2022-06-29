package com.leaquan.petinder.util.extension

import android.util.Log

fun WTF(msg: String?, tag: String = "WTF"): Int{
    return Log.e(tag, "$msg")
}
